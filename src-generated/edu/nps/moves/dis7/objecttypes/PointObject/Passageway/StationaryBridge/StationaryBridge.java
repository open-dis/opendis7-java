package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class StationaryBridge extends ObjectType
{
    public StationaryBridge()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)1); // Stationary Bridge
    }
}
