package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDrop_Uncovered;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class RockDrop_Uncovered extends ObjectType
{
    public RockDrop_Uncovered()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)5); // Rock Drop
        setSubCategory((byte)2); // Rock Drop, Uncovered
    }
}
