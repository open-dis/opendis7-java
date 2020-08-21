package edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Tracks_Tire;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
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
