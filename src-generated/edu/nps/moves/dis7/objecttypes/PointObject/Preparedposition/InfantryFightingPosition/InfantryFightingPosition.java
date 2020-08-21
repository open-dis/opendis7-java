package edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
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
