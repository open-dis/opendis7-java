package edu.nps.moves.dis.objecttypes.ObjectTypes_ArealObject.Obstacle;

import edu.nps.moves.dis.enumerations.*;
import edu.nps.moves.dis.objecttypes.ObjectTypes_ArealObject.ArealObject;

abstract public class Base extends ArealObject
{
    public Base()
    {
    	setDomain(PlatformDomain.OTHER);
        setObjectKind(ObjectKind.OBSTACLE);
    }
}
