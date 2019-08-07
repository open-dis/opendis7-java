package edu.nps.moves.dis.objecttypes.LinearObject.Culturalfeature.Tracks_Tire;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class Tracks_Tire extends ObjectType
{
    public Tracks_Tire()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)2); // Tracks, Tire
    }
}
