package edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Wire.Wire_Crush;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class Wire_Crush extends ObjectType
{
    public Wire_Crush()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)1); // Wire
        setSubCategory((byte)1); // Wire, Crush
    }
}
