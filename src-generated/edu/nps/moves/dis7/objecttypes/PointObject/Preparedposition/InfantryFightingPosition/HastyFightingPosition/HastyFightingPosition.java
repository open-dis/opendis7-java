package edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.HastyFightingPosition;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class HastyFightingPosition extends ObjectType
{
    public HastyFightingPosition()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(2)); // Prepared position
        setCategory((byte)2); // Infantry Fighting Position
        setSubCategory((byte)5); // Hasty Fighting Position
    }
}
