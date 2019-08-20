package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Construction;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Barrier_Construction extends ObjectType
{
    public Barrier_Construction()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)4); // Barrier
        setSubCategory((byte)6); // Barrier, Construction
    }
}
