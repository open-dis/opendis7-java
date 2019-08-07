package edu.nps.moves.dis.objecttypes.PointObject.Culturalfeature.DisturbedEarth;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class DisturbedEarth extends ObjectType
{
    public DisturbedEarth()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)3); // Disturbed Earth
    }
}
