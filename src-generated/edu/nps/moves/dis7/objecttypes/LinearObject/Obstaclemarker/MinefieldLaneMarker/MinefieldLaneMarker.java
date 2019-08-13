package edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.MinefieldLaneMarker;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class MinefieldLaneMarker extends ObjectType
{
    public MinefieldLaneMarker()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(6)); // Obstacle marker
        setCategory((byte)1); // Minefield Lane Marker
    }
}
