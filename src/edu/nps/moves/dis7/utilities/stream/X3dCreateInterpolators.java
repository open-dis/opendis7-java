package edu.nps.moves.dis7.utilities.stream;

import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
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
public class X3dCreateInterpolators {

    private byte[] bufferShort;

    // -------------------- Begin Variables for Position Interpolator
    private Boolean firstTimeStamp = true;
    private int firstLocalTimeStamp = 0;

    private double firstLocalX = 0;
    private double firstLocalY = 0;
    private double firstLocalZ = 0;

    private Map<Double, X3dCoordinates> testMap = new LinkedHashMap<>();

    //Setting up a NumberFormatter for limitting the decimal count to 3
    private NumberFormat coordinateNumberFormat = NumberFormat.getInstance(new Locale("en", "US"));

    // -------------------- End Variables for Position Interpolator

    /** Default Constructor */
    public X3dCreateInterpolators() {

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
            ByteBuffer espduByteBuffer = ByteBuffer.wrap(bufferShort);
            try {
                localEspdu.unmarshal(espduByteBuffer);
            } catch (Exception ex) {
                Logger.getLogger(X3dCreateInterpolators.class.getName()).log(Level.SEVERE, null, ex);
            }

            double localTimeStamp;
            double localX;
            double localY;
            double localZ;

            double localPhi;
            double localPsi;
            double localTheta;

            //Store the first timestamp to subtract it from all others
            //Same with X,Y,Z to create a local coordiante system
            if (firstTimeStamp) {

                firstLocalTimeStamp = localPdu.getTimestamp();
                firstLocalX = localEspdu.getEntityLocation().getX();
                firstLocalY = localEspdu.getEntityLocation().getZ();
                firstLocalZ = -1 * localEspdu.getEntityLocation().getY();

                firstTimeStamp = false;
            }

            localTimeStamp = localPdu.getTimestamp();
            localX = localEspdu.getEntityLocation().getX();
            localY = localEspdu.getEntityLocation().getZ();
            localZ = -1 * localEspdu.getEntityLocation().getY();
            localPhi = localEspdu.getEntityOrientation().getPhi();
            localPsi = localEspdu.getEntityOrientation().getPsi();
            localTheta = localEspdu.getEntityOrientation().getTheta();

            localTimeStamp = localTimeStamp - firstLocalTimeStamp;
            localX = localX - firstLocalX;
            localY = localY - firstLocalY;
            localZ = localZ - firstLocalZ;

            //Divide TimeStamp by 1,300,000 to get something close to a second per Unit.
            //According to the DIS standard one tick is 3600/(2^31) seconds ~ 1.6764 µs
            //1,100,000 was derived from a stream that is 83 seconds long. The number was adjusted to get a timesensor with 83 seconds
            //ToDo find the real conversion between TimeStampDelta and seconds
            localTimeStamp = localTimeStamp / 1100000;

            //Only add to stream if it is an ESPDU
            //ToDo: Add support for multiple Entities
            if ((localPdu.getPduType() != null) && (localPdu.getPduType() == DISPDUType.ENTITY_STATE))
                testMap.put(localTimeStamp, new X3dCoordinates(localX, localY, localZ, localPhi, localPsi, localTheta));
        }
    }

    public void makeX3dInterpolator()
    {
        //Compression of the testMap.
        //Remove all collinear points.
        X3dSlidingWindowCompression slidingWindowCompression = new X3dSlidingWindowCompression(testMap);

        //To turn of the compression just comment the next line out and the very next in.
        Map<Double, X3dCoordinates> returnMap = slidingWindowCompression.doSlidingWindow();
        //returnMap.putAll(testMap);

        //Writing all values from the KeyMap to a proper Position Interpolator String
        System.out.println("Writing Position and Rotation Interpolator");
        Set<Double> keys = returnMap.keySet();
        //Set<Double> keys = tempKeyKeyValueSetPositionInterPolator.keySet();
        String positionKey = "key = '";
        String positionKeyValue = "keyValue = '";
        String positionInterpolatorToCopy = "<PositionInterpolator DEF='EntityPosition' ";

        String orientationKeyX = "key = '";
        String orientationKeyValueX = "keyValue = '";
        String orientationInterpolatorToCopyX = "<OrientationInterpolator DEF='EntityOrientationX' ";

        String orientationKeyY = "key = '";
        String orientationKeyValueY = "keyValue = '";
        String orientationInterpolatorToCopyY = "<OrientationInterpolator DEF='EntityOrientationY' ";

        String orientationKeyZ = "key = '";
        String orientationKeyValueZ = "keyValue = '";
        String orientationInterpolatorToCopyZ = "<OrientationInterpolator DEF='EntityOrientationZ' ";

        //Find highest time to do the normalization
        double lastTimeStamp = 0;

        for (Double k : keys) {

            if (k > lastTimeStamp)
                lastTimeStamp = k;
        }

        //Normalize all times in the set
        Map<Double, String> keyKeyValueSetPositionInterpolator = new LinkedHashMap<>();

        Map<Double, String> keyKeyValueSetOrientationInterpolatorX = new LinkedHashMap<>();
        Map<Double, String> keyKeyValueSetOrientationInterpolatorY = new LinkedHashMap<>();
        Map<Double, String> keyKeyValueSetOrientationInterpolatorZ = new LinkedHashMap<>();
        
        double tempX;
        double tempY;
        double tempZ ;

        double tempPhi;
        double tempPsi;
        double tempTheta;
        
        String localCoordinateString;
        String localOrientationStringX;
        String localOrientationStringY;
        String localOrientationStringZ;

        for (Double k : keys) {

            tempX = returnMap.get(k).getX();
            tempY = returnMap.get(k).getY();
            tempZ = returnMap.get(k).getZ();

            tempPhi = returnMap.get(k).getPhi() / 6.28;
            tempPsi = returnMap.get(k).getPsi() / 6.28;
            tempTheta = returnMap.get(k).getTheta() / 6.28;

            localCoordinateString = " " + coordinateNumberFormat.format(tempX) + " " + coordinateNumberFormat.format(tempY) + " " + coordinateNumberFormat.format(tempZ);
            localOrientationStringX = " 1 0 0 " + coordinateNumberFormat.format(tempPhi);
            localOrientationStringY = " 0 1 0 " + coordinateNumberFormat.format(tempTheta);
            localOrientationStringZ = " 0 0 1 " + coordinateNumberFormat.format(tempPsi);

            keyKeyValueSetPositionInterpolator.put(k / lastTimeStamp, localCoordinateString);
            keyKeyValueSetOrientationInterpolatorX.put(k / lastTimeStamp, localOrientationStringX);
            keyKeyValueSetOrientationInterpolatorY.put(k / lastTimeStamp, localOrientationStringY);
            keyKeyValueSetOrientationInterpolatorZ.put(k / lastTimeStamp, localOrientationStringZ);

        }

        keys = keyKeyValueSetPositionInterpolator.keySet();

        //Setting up the timeSensor
        //Only one timeSensor for both interpolators is needed
        String timeSensor = "<TimeSensor DEF='PduStreamClock' cycleInterval='";

        timeSensor += lastTimeStamp;

        timeSensor += "' loop = 'true'/>";

        //Printing the timeSensor to the console
        System.out.println(timeSensor);

        //Setting up PositionInterpolator and OrientationInterpolator
        for (Double k : keys) {
            //System.out.println("Time: " + k + " Position (x,y,z) " + keyKeyValueSetPositionInterpolator.get(k));

            //PositionInterpolator
            positionKey += coordinateNumberFormat.format(k) + " ";
            positionKeyValue += keyKeyValueSetPositionInterpolator.get(k) + " ";

            //OrientationInterpolator for X (phi)
            orientationKeyX += coordinateNumberFormat.format(k) + " ";
            orientationKeyValueX += keyKeyValueSetOrientationInterpolatorX.get(k) + " ";

            //OrientationInterpolator for Y (theta)
            orientationKeyY += coordinateNumberFormat.format(k) + " ";
            orientationKeyValueY += keyKeyValueSetOrientationInterpolatorY.get(k) + " ";

            //OrientationInterpolator for Z (psi)
            orientationKeyZ += coordinateNumberFormat.format(k) + " ";
            orientationKeyValueZ += keyKeyValueSetOrientationInterpolatorZ.get(k) + " ";

        }
        positionKey += "' ";
        positionKeyValue += "' ";

        orientationKeyX += "' ";
        orientationKeyValueX += "' ";

        orientationKeyY += "' ";
        orientationKeyValueY += "' ";

        orientationKeyZ += "' ";
        orientationKeyValueZ += "' ";

        //PositionInterpolator
        positionInterpolatorToCopy += positionKey + "\n";
        positionInterpolatorToCopy += positionKeyValue;
        positionInterpolatorToCopy += "/>";

        //PositionInterpolator for X
        orientationInterpolatorToCopyX += orientationKeyX + "\n";
        orientationInterpolatorToCopyX += orientationKeyValueX;
        orientationInterpolatorToCopyX += "/>";

        //PositionInterpolator for Y
        orientationInterpolatorToCopyY += orientationKeyY + "\n";
        orientationInterpolatorToCopyY += orientationKeyValueY;
        orientationInterpolatorToCopyY += "/>";

        //PositionInterpolator for Z
        orientationInterpolatorToCopyZ += orientationKeyY + "\n";
        orientationInterpolatorToCopyZ += orientationKeyValueZ;
        orientationInterpolatorToCopyZ += "/>";

        //Printing PositionInterpolator to the console
        System.out.println(positionInterpolatorToCopy);

        //First Rotation must be around z axis by psi
        //Printing OrientationInterpolator for X to the console
        System.out.println(orientationInterpolatorToCopyZ);

        //Second Rotation must be around resulting y (y') axis by theta
        //Printing OrientationInterpolator for Y to the console
        System.out.println(orientationInterpolatorToCopyY);

        //last rotation must be around resulting x (x') axis by phi
        //Printing OrientationInterpolator for Z to the console
        System.out.println(orientationInterpolatorToCopyX);
    }

}
