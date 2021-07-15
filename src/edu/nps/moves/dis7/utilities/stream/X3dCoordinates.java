package edu.nps.moves.dis7.utilities.stream;

/**
 * This class is a holder for coordinates and angles of ESPDUs to store them in
 * HashMaps
 *
 * @author Tobias Brennenstuhl @ NPS
 */
public class X3dCoordinates {

    private double x;
    private double y;
    private double z;
    private double phi;
    private double psi;
    private double theta;

    /** Default constructor */
    public X3dCoordinates() {
        this(0.0,0.0,0.0,0.0,0.0,0.0);
    }

    /**
     * 
     * @param x coordinate
     * @param y coordinate
     * @param z coordinate
     * @param phi orientation
     * @param psi orientation
     * @param theta orientation 
     */
    public X3dCoordinates(double x, double y, double z, double phi, double psi, double theta) {
        this.x= x;
        this.y = y;
        this.z = z;
        this.phi = phi;
        this.psi = psi;
        this.theta = theta;
    }

    /** accessor method for angle of rotation
     * @return current value */
    public double getPhi() {
        return phi;
    }

    /** accessor method to set angle of rotation
     * @param phi new angle value */
    public void setPhi(double phi) {
        this.phi = phi;
    }

    /** accessor method for angle of rotation
     * @return current value */
    public double getPsi() {
        return psi;
    }

    /** accessor method to set angle of rotation
     * @param psi new angle value */
    public void setPsi(double psi) {
        this.psi = psi;
    }

    /** accessor method for angle of rotation
     * @return current value */
    public double getTheta() {
        return theta;
    }

    /** accessor method to set angle of rotation
     * @param theta new angle value */
    public void setTheta(double theta) {
        this.theta = theta;
    }

    /** accessor method to get coordinate x value
      * @return current value */
    public double getX() {
        return x;
    }

    /** accessor method to set coordinate x value
     * @param x coordinate value to set */
    public void setX(double x) {
        this.x = x;
    }

    /** accessor method to get coordinate y value
      * @return current value */
    public double getY() {
        return y;
    }

    /** accessor method to set coordinate y value
     * @param y coordinate value to set */
    public void setY(double y) {
        this.y = y;
    }

    /** accessor method to get coordinate z value
      * @return current value */
    public double getZ() {
        return z;
    }

    /** accessor method to set coordinate z value
     * @param z coordinate value to set */
    public void setZ(double z) {
        this.z = z;
    }

}
