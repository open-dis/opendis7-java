package edu.nps.moves.dis7.objectTypes.LinearObject.Tacticalsmoke.ExhaustSmoke;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * ObjectType uid: 227
 */
public class ExhaustSmoke extends ObjectType
{
    /** Default constructor */
    public ExhaustSmoke()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)1); // Exhaust Smoke
    }
}
