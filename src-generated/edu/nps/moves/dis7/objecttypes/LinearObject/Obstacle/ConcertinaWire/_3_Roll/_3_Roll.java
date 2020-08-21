package edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire._3_Roll;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 227
 */
public class _3_Roll extends ObjectType
{
    public _3_Roll()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)2); // Concertina Wire
        setSubCategory((byte)2); // 3-Roll
    }
}
