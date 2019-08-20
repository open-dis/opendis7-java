package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Fence_Chain_6_foot;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Barrier_Fence_Chain_6_foot extends ObjectType
{
    public Barrier_Fence_Chain_6_foot()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)4); // Barrier
        setSubCategory((byte)8); // Barrier, Fence, Chain, 6-foot
    }
}
