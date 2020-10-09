package edu.nps.moves.dis7.objectTypes.ArealObject.Obstacle.Minefield;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 228
 */
public class Prepared extends ObjectType
{
    public Prepared()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)1); // Minefield
        setSubCategory((byte)2); // Prepared
    }
}
