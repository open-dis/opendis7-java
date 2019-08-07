package edu.nps.moves.dis.objecttypes.PointObject.Tacticalsmoke.AirBurst;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class AirBurst extends ObjectType
{
    public AirBurst()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)2); // Air Burst
    }
}
