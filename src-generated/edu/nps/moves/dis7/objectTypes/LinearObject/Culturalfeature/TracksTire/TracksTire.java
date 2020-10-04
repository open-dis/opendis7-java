package edu.nps.moves.dis7.objectTypes.LinearObject.Culturalfeature.TracksTire;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 227
 */
public class TracksTire extends ObjectType
{
    public TracksTire()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)2); // Tracks, Tire
    }
}
