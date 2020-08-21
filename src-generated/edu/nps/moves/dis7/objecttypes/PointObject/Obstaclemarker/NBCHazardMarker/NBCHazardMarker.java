package edu.nps.moves.dis7.objecttypes.PointObject.Obstaclemarker.NBCHazardMarker;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class NBCHazardMarker extends ObjectType
{
    public NBCHazardMarker()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(6)); // Obstacle marker
        setCategory((byte)2); // NBC Hazard Marker
    }
}
