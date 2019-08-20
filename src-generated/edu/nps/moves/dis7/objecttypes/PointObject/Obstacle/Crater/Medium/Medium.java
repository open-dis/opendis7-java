package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Medium;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Medium extends ObjectType
{
    public Medium()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)3); // Crater
        setSubCategory((byte)2); // Medium
    }
}
