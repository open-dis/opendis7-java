package edu.nps.moves.dis7.utilities.stream;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Tobias Brennenstuhl @ NPS
 */
public class X3dSlidingWindowCompression {

    private LinkedHashMap<Double, X3dCoordinates> localMap;

    public X3dSlidingWindowCompression(LinkedHashMap<Double, X3dCoordinates> localHashMap) {

        this.localMap = new LinkedHashMap<>();
        Set<Double> keys = localHashMap.keySet();
        for (Double k : keys) {
            localMap.put(k, localHashMap.get(k));
        }
    }

    public TreeMap<Double, X3dCoordinates> doSlidingWindow() {

        System.out.println("DISTools.Regression.doRegression()");
        //Check whether points could be deleted to compress the stream
        //https://www.crashkurs-statistik.de/einfache-lineare-regression/
        TreeMap<Double, X3dCoordinates> streamMap = new TreeMap<>();
        //Copy LinkedHashMap into TreeMap to be able to pull the first element.
        streamMap.putAll(localMap);
        TreeMap<Double, X3dCoordinates> returnMap = new TreeMap<>();
        //TreeMap of slidingWindows will store all of the points that are currently processed
        //use .pullFirstEntry() to get rid of the points at the beginning.
        TreeMap<Double, X3dCoordinates> slidingWindow = new TreeMap<>();

        while (streamMap.size() > 0) {
            slidingWindow.put(streamMap.firstEntry().getKey(), streamMap.get(streamMap.firstEntry().getKey()));
            streamMap.pollFirstEntry();

            //Calculate the mean and SD
            Set<Double> slidingWindowKeys = slidingWindow.keySet();

            if (slidingWindow.size() >= 3) {

                List<Double> tList = new ArrayList<>();
                List<Double> xList = new ArrayList<>();
                List<Double> yList = new ArrayList<>();
                List<Double> zList = new ArrayList<>();
                List<Double> phiList = new ArrayList<>();
                List<Double> psiList = new ArrayList<>();
                List<Double> thetaList = new ArrayList<>();

                Double[] k = new Double[slidingWindowKeys.size()];
                slidingWindowKeys.toArray(k);

                for (int i = 0; i < slidingWindow.size(); i++) {

                    tList.add(i, k[i]);

                    phiList.add(i, slidingWindow.get(k[i]).getPhi());
                    psiList.add(i, slidingWindow.get(k[i]).getPsi());
                    thetaList.add(i, slidingWindow.get(k[i]).getTheta());
                    xList.add(i, slidingWindow.get(k[i]).getX());
                    yList.add(i, slidingWindow.get(k[i]).getY());
                    zList.add(i, slidingWindow.get(k[i]).getZ());

                }

                //Calculate Area of Triangle
                //Credit: http://www.ambrsoft.com/TrigoCalc/Line3D/LineColinear.htm
                for (int i = 0; i < slidingWindow.size(); i++) {

                    double a = sqrt(pow(xList.get(1) - xList.get(0), 2) + pow(yList.get(1) - yList.get(0), 2) + pow(zList.get(1) - zList.get(0), 2));
                    double b = sqrt(pow(xList.get(i) - xList.get(0), 2) + pow(yList.get(i) - yList.get(0), 2) + pow(zList.get(i) - zList.get(0), 2));
                    double c = sqrt(pow(xList.get(i) - xList.get(1), 2) + pow(yList.get(i) - yList.get(1), 2) + pow(zList.get(i) - zList.get(1), 2));
                    double s = (a + b + c) / 2;
                    double areaA = sqrt(s * (s - a) * (s - b) * (s - c));

                    if ((areaA >= 0.1) || (tList.get(i) - tList.get(0) >= 4.0)) {
                        //grab the first and the last point from the sliding window and push it to the returnMap
                        X3dCoordinates firstPoint = new X3dCoordinates();
                        firstPoint.setX(xList.get(0));
                        firstPoint.setY(yList.get(0));
                        firstPoint.setZ(zList.get(0));
                        firstPoint.setPhi(phiList.get(0));
                        firstPoint.setPsi(psiList.get(0));
                        firstPoint.setTheta(thetaList.get(0));

                        X3dCoordinates lastPoint = new X3dCoordinates(xList.get(i), yList.get(i), zList.get(i), phiList.get(i), psiList.get(i), thetaList.get(i));

                        returnMap.put(tList.get(0), firstPoint);
                        returnMap.put(tList.get(i), lastPoint);

                        slidingWindow.clear();

                        tList.clear();
                        xList.clear();
                        yList.clear();
                        zList.clear();
                        phiList.clear();
                        psiList.clear();
                        thetaList.clear();

                        break;
                    }

                    if ((areaA <= 0.1) && (tList.get(i) - tList.get(0) <= 4.0) && streamMap.size() == 0) {

                        //System.out.println("StreamMap empty. All points left will be added. Break");
                        //grab the first and the last point from the siding window and push it to the returnMap
                        for (int j = 0; j < slidingWindow.size(); j++) {
                            X3dCoordinates leftPoints = new X3dCoordinates(xList.get(j), yList.get(j), zList.get(j), phiList.get(j), psiList.get(j), thetaList.get(j));
                            returnMap.put(tList.get(j), leftPoints);
                        }

                        break;
                    }
                    //System.out.println("Area of Triangle: " + areaA);
                }

            }

        }

        return returnMap;

    }
;

}
