package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge._4_Lane;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class _4_Lane extends ObjectType
{
    public _4_Lane()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)1); // Stationary Bridge
        setSubCategory((byte)2); // 4-Lane
    }
}
