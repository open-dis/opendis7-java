package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Small;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Small extends ObjectType
{
    public Small()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)3); // Crater
        setSubCategory((byte)1); // Small
    }
}
