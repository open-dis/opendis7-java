package edu.nps.moves.dis7.objectTypes.LinearObject.Obstacle.ConcertinaWire;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 227
 */
public class _3Roll extends ObjectType
{
    public _3Roll()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)2); // Concertina Wire
        setSubCategory((byte)2); // 3-Roll
    }
}
