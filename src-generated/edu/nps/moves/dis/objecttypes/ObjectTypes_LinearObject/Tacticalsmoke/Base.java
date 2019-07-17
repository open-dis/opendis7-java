package edu.nps.moves.dis.objecttypes.ObjectTypes_LinearObject.Tacticalsmoke;

import edu.nps.moves.dis.enumerations.*;
import edu.nps.moves.dis.objecttypes.ObjectTypes_LinearObject.LinearObject;

abstract public class Base extends LinearObject
{
    public Base()
    {
    	setDomain(PlatformDomain.OTHER);
        setObjectKind(ObjectKind.TACTICAL_SMOKE);
    }
}
