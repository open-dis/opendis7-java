package edu.nps.moves.dis7.objectTypes.PointObject.Culturalfeature.DisturbedRoad;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class DisturbedRoadAsphalt extends ObjectType
{
    public DisturbedRoadAsphalt()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)4); // Disturbed Road
        setSubCategory((byte)2); // Disturbed Road, Asphalt
    }
}
