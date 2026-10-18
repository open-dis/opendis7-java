package DisDemo;

import edu.nps.moves.dis7.pdus.*;

/**
 * Abstract superclass for moving entities. Initialized with a starting
 * position (IN LOCAL COORDINATES). Step() performs one quanta of moving
 * the thing around. After movement you can retrieve the new position with
 * getPosition(), convert it to global DIS coordinates, and be on your way.
 * 
 * @author DMcG
 */
public abstract class EntityMover 
{
    Vector3Double position;
    
    /** Superclass constructor
     * @param startPosition initial coordinate point */
    public EntityMover(Vector3Double startPosition)
    {
        this.position = startPosition;
    }
    /** single-step movement */
    public abstract void step();
    
    /** provide current location
      * @return current location */
    public Vector3Double getPosition()
    {
        return position;
    }
    
}
