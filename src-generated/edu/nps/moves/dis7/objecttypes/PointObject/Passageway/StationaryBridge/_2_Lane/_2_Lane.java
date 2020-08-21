package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge._2_Lane;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class _2_Lane extends ObjectType
{
    public _2_Lane()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)1); // Stationary Bridge
        setSubCategory((byte)1); // 2-Lane
    }
}
