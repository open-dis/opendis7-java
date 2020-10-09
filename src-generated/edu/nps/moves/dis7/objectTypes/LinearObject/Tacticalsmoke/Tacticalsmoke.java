package edu.nps.moves.dis7.objectTypes.LinearObject.Tacticalsmoke;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
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
