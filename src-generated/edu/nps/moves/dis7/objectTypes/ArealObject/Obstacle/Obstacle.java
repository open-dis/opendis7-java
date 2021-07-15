package edu.nps.moves.dis7.objectTypes.ArealObject.Obstacle;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * ObjectType uid: 228
 */
public class Obstacle extends ObjectType
{
    /** Default constructor */
    public Obstacle()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
    }
}
