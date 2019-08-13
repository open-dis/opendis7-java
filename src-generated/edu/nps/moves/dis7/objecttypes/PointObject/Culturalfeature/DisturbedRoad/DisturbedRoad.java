package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class DisturbedRoad extends ObjectType
{
    public DisturbedRoad()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)4); // Disturbed Road
    }
}
