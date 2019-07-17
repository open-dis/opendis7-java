package edu.nps.moves.dis.objecttypes.ObjectTypes_PointObject.Culturalfeature;

import edu.nps.moves.dis.enumerations.*;
import edu.nps.moves.dis.objecttypes.ObjectTypes_PointObject.PointObject;

abstract public class Base extends PointObject
{
    public Base()
    {
    	setDomain(PlatformDomain.LAND);
        setObjectKind(ObjectKind.CULTURAL_FEATURE);
    }
}
