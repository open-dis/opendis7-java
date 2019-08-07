package edu.nps.moves.dis.objecttypes.LinearObject.Obstaclebreach.Breach;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class Breach extends ObjectType
{
    public Breach()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(7)); // Obstacle breach
        setCategory((byte)1); // Breach
    }
}
