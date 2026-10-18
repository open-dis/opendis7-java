package DisDemo;

import edu.nps.moves.dis7.pdus.*;

/**
 * Logic for moving something around in a square using a local coordinate system,
 * ENU. East is positive X, north is positive Y, positive Z is "up". 
 * 
 * @author DMcG
 */
public class EntityMoverSquare extends EntityMover
{
    /** How much an entity moves every quanta */
    private static final int STEP_SIZE = 1;
    /** How big the square we move around is */
    private static final int SQUARE_SIZE = 50;  // size of a side to the square, in meters
    /** Directions we can travel. */
    public enum Direction{
        /** value choice */
        NORTH, 
        /** value choice */
        EAST, 
        /** value choice */
        SOUTH, 
        /** value choice */
        WEST};
    
    /** direction of movement */
    public Direction currentDirection;
    
    /** instance constructor
     * @param position initial coordinate */
    public EntityMoverSquare(Vector3Double position)
    {
        super(position);
        this.currentDirection = Direction.NORTH;
    }
    
    @Override
    public void step()
    {
        switch(currentDirection)
        {
            case NORTH:
                position.setY( position.getY() + STEP_SIZE);
                if(position.getY() >= SQUARE_SIZE)
                {
                    currentDirection = Direction.EAST;
                }
                break;
                
            case EAST:
                position.setX( position.getX() + STEP_SIZE);
                if(position.getX() >= SQUARE_SIZE)
                {
                    currentDirection = Direction.SOUTH;
                }
                break;
                
            case SOUTH: 
                position.setY( position.getY() - STEP_SIZE);
                if(position.getY() <= 0.0)
                {
                    currentDirection = Direction.WEST;
                }
                break;
                
                
            case WEST:
                
                position.setX( position.getX() - STEP_SIZE);
                if(position.getX() <= 0.0)
                {
                    currentDirection = Direction.NORTH;
                }
                break;
                
            default:
                System.out.println("Unrecognized direction");
        }
        
        System.out.println("Current position: " + position.getX() + ", " + position.getY() + ", " + position.getZ());
        
    }

}
