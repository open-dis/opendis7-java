package edu.nps.moves.dis.objecttypes.ObjectTypes_PointObject.Tacticalsmoke;

import edu.nps.moves.dis.enumerations.*;
import edu.nps.moves.dis.objecttypes.ObjectTypes_PointObject.PointObject;

abstract public class Base extends PointObject
{
    public Base()
    {
    	setDomain(PlatformDomain.OTHER);
        setObjectKind(ObjectKind.TACTICAL_SMOKE);
    }
}
