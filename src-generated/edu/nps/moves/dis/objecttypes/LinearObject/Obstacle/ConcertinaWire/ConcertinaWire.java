package edu.nps.moves.dis.objecttypes.LinearObject.Obstacle.ConcertinaWire;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class ConcertinaWire extends ObjectType
{
    public ConcertinaWire()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)2); // Concertina Wire
    }
}
