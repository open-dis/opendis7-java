package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge._4_Lane;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class _4_Lane extends ObjectType
{
    public _4_Lane()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)3); // Ribbon Bridge
        setSubCategory((byte)2); // 4-Lane
    }
}
