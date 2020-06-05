/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nps.moves.dis7.utilities.stream;

import edu.nps.moves.dis7.EntityStatePdu;
import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.enumerations.DISPDUType;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobias Brennenstuhl @ NPS
 */
public class X3dCreateLineSet {

    private byte[] bufferShort;

    // -------------------- Begin Variables for Position Interpolator
    private Boolean firstTimeStamp = true;
    private int firstLocalTimeStamp = 0;

    private double firstLocalX = 0;
    private double firstLocalY = 0;
    private double firstLocalZ = 0;

    private LinkedHashMap<Double, X3dCoordinates> testMap = new LinkedHashMap<>();

    //Setting up a NumberFormatter for limitting the decimal count to 3
    private NumberFormat coordinateNumberFormat = NumberFormat.getInstance(new Locale("en", "US"));

    // -------------------- End Variables for Position Interpolator
    public X3dCreateLineSet() {

        //3 significant digits equals milimeter position accuracy and 0.001 radians = 0.0572963266634555‬ degrees
        coordinateNumberFormat.setMaximumFractionDigits(3);

    }

    public void addPointsToMap(byte[] localBufferShort) {

        this.bufferShort = localBufferShort.clone();

        if (bufferShort[2] == 1) {

            //PDU Factory
            PduFactory pduFactory = new PduFactory();
            Pdu localPdu = pduFactory.createPdu(bufferShort);

            // ToDO figure out how to do this! makeEntityStatePDU
            EntityStatePdu localEspdu = pduFactory.makeEntityStatePdu();
            //Put all the data we need into the localEspdu
            ByteBuffer espduBuffer = ByteBuffer.wrap(bufferShort);
            try {
                localEspdu.unmarshal(espduBuffer);
            } catch (Exception ex) {
                Logger.getLogger(X3dCreateLineSet.class.getName()).log(Level.SEVERE, null, ex);
            }

            double localTimeStamp;
            double localX;
            double localY;
            double localZ;

            //TimeStamps for a lineSet is not needed but copied from X3DInterpolators to use them as key for the hashmap
            // and the standard compression class can be used
            //Store the first timestamp to subtract it from all others
            //Same with X,Y,Z to create a local coordiante system
            if (firstTimeStamp) {

                firstLocalTimeStamp = localPdu.getTimestamp();
//            localTimeStamp = localPdu.getTimestamp();
                firstLocalX = localEspdu.getEntityLocation().getX();
                firstLocalY = localEspdu.getEntityLocation().getZ();
                firstLocalZ = -1 * localEspdu.getEntityLocation().getY();

                firstTimeStamp = false;
            }

            localTimeStamp = localPdu.getTimestamp();
            localX = localEspdu.getEntityLocation().getX();
            localY = localEspdu.getEntityLocation().getZ();
            localZ = -1 * localEspdu.getEntityLocation().getY();

            //Debug for printing X,Y,Z
            //System.out.println(localX + " " + localY + " " + localZ);
            localTimeStamp = localTimeStamp - firstLocalTimeStamp;
            localX = localX - firstLocalX;
            localY = localY - firstLocalY;
            localZ = localZ - firstLocalZ;

            //Divide TimeStamp by 1,300,000 to get something close to a second per Unit.
            //According to the DIS standard one tick is 3600/(2^31) seconds ~ 1.6764 µs
            //1,300,000 was derived from a stream that is 61 seconds long. The number was adjusted to get a timesensor with 61 seconds
            //ToDo find the real conversion between TimeStampDelta and seconds
            localTimeStamp = localTimeStamp / 1300000;

            //Only add to stream if it is an ESPDU
            //ToDo: Add support for multiple Entities
            if ((localPdu.getPduType() != null) && (localPdu.getPduType() == DISPDUType.ENTITY_STATE)) {

                testMap.put(localTimeStamp, new X3dCoordinates(localX, localY, localZ, 0.0, 0.0, 0.0));

            }
        }
    }

    public void makeX3dLineSet() {

        //Compression of the testMap.
        //Remove all collinear points.
        X3dSlidingWindowCompression regression = new X3dSlidingWindowCompression(testMap);

        //To turn of the compression just comment the next line out and the very next in.
        Map<Double, X3dCoordinates> returnMap = regression.doSlidingWindow();
        //returnMap.putAll(testMap);

        //Writing all values from the KeyMap to a proper Position Interpolator String
        System.out.println("Writing X3D LineSet");
        Set<Double> keys = returnMap.keySet();
        String lineSetPoints = "";
        String lineSet = "<LineSet vertexCount='" + returnMap.size() + "'> \n <Coordinate point='";

        //Find highest time to do the normalization
        double lastTimeStamp = 0;

        for (Double k : keys) {

            if (k > lastTimeStamp) {

                lastTimeStamp = k;

            }
        }

        //Normalize all times in the set
        LinkedHashMap<Double, String> keyKeyValueSetPositionInterpolator = new LinkedHashMap<>();

        for (Double k : keys) {

            String localCoordinateString;

            double tempX = returnMap.get(k).getX();
            double tempY = returnMap.get(k).getY();
            double tempZ = returnMap.get(k).getZ();

            localCoordinateString = " " + coordinateNumberFormat.format(tempX) + " " + coordinateNumberFormat.format(tempY) + " " + coordinateNumberFormat.format(tempZ);

            keyKeyValueSetPositionInterpolator.put(k / lastTimeStamp, localCoordinateString);

        }

        keys = keyKeyValueSetPositionInterpolator.keySet();

     

        //Setting up PositionInterpolator and OrientationInterpolator
        for (Double k : keys) {


            lineSetPoints += keyKeyValueSetPositionInterpolator.get(k) + " ";

        }

        lineSetPoints += "' ";

        //PositionInterpolator

        lineSet += lineSetPoints;
        lineSet += "/> \n </LineSet> \n";

        //Printing PositionInterpolator to the console
        System.out.println(lineSet);

    }

}
