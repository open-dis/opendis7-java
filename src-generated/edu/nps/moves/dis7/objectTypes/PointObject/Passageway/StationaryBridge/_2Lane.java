package edu.nps.moves.dis7.objectTypes.PointObject.Passageway.StationaryBridge;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class _2Lane extends ObjectType
{
    public _2Lane()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)1); // Stationary Bridge
        setSubCategory((byte)1); // 2-Lane
    }
}
