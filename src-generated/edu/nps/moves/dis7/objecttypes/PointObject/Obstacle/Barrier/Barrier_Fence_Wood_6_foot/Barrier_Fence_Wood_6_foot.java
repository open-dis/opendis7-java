package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Fence_Wood_6_foot;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Barrier_Fence_Wood_6_foot extends ObjectType
{
    public Barrier_Fence_Wood_6_foot()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)4); // Barrier
        setSubCategory((byte)9); // Barrier, Fence, Wood, 6-foot
    }
}
