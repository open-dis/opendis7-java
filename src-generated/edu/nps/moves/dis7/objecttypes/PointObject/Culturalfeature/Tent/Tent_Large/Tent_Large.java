package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Large;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Tent_Large extends ObjectType
{
    public Tent_Large()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)5); // Tent
        setSubCategory((byte)3); // Tent, Large
    }
}
