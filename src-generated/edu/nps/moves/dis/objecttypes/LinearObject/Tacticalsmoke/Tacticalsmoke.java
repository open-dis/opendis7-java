package edu.nps.moves.dis.objecttypes.LinearObject.Tacticalsmoke;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class Tacticalsmoke extends ObjectType
{
    public Tacticalsmoke()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
    }
}
