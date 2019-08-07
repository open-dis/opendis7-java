package edu.nps.moves.dis.objecttypes.PointObject.Preparedposition.InfantryFightingPosition;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class InfantryFightingPosition extends ObjectType
{
    public InfantryFightingPosition()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(2)); // Prepared position
        setCategory((byte)2); // Infantry Fighting Position
    }
}
