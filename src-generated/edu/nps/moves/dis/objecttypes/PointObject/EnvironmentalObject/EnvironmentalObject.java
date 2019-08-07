package edu.nps.moves.dis.objecttypes.PointObject.EnvironmentalObject;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class EnvironmentalObject extends ObjectType
{
    public EnvironmentalObject()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(8)); // Environmental Object
    }
}
