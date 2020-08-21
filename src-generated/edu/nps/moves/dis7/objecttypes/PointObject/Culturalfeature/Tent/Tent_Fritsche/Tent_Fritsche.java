package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Fritsche;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Tent_Fritsche extends ObjectType
{
    public Tent_Fritsche()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)5); // Tent
        setSubCategory((byte)8); // Tent, Fritsche
    }
}
