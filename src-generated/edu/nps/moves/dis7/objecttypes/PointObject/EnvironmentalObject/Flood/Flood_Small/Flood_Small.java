package edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.Flood_Small;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Flood_Small extends ObjectType
{
    public Flood_Small()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(8)); // Environmental Object
        setCategory((byte)1); // Flood
        setSubCategory((byte)1); // Flood, Small
    }
}
