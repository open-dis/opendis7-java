package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.M60A1;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class M60A1 extends ObjectType
{
    public M60A1()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)2); // AVLB
        setSubCategory((byte)1); // M60A1
    }
}
