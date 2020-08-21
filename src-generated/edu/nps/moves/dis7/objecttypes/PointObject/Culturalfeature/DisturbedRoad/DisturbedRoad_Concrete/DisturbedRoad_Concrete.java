package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad_Concrete;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class DisturbedRoad_Concrete extends ObjectType
{
    public DisturbedRoad_Concrete()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)4); // Disturbed Road
        setSubCategory((byte)3); // Disturbed Road, Concrete
    }
}
