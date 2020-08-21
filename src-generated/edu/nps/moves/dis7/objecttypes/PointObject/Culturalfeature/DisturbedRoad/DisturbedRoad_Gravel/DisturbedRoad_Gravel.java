package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad_Gravel;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class DisturbedRoad_Gravel extends ObjectType
{
    public DisturbedRoad_Gravel()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)4); // Disturbed Road
        setSubCategory((byte)1); // Disturbed Road, Gravel
    }
}
