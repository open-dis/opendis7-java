package edu.nps.moves.dis.objecttypes.ArealObject.Obstacle;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 228
 */
public class Obstacle extends ObjectType
{
    public Obstacle()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
    }
}
