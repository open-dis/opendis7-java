package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.DragonsTeeth;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class DragonsTeeth extends ObjectType
{
    public DragonsTeeth()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)4); // Barrier
        setSubCategory((byte)1); // Dragon’s Teeth
    }
}
