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
     * @param x
     * @param y
     * @param z
     * @param phi
     * @param psi
     * @param theta 
     */
    public X3dCoordinates(double x, double y, double z, double phi, double psi, double theta) {
        this.x= x;
        this.y = y;
        this.z = z;
        this.phi = phi;
        this.psi = psi;
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getPsi() {
        return psi;
    }

    public void setPsi(double psi) {
        this.psi = psi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

}
