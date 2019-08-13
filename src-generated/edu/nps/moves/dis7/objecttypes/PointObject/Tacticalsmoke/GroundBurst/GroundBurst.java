package edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class GroundBurst extends ObjectType
{
    public GroundBurst()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)1); // Ground Burst
    }
}
