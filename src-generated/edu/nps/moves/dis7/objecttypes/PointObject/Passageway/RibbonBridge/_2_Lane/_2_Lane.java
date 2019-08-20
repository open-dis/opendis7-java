package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge._2_Lane;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class _2_Lane extends ObjectType
{
    public _2_Lane()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)3); // Ribbon Bridge
        setSubCategory((byte)1); // 2-Lane
    }
}
