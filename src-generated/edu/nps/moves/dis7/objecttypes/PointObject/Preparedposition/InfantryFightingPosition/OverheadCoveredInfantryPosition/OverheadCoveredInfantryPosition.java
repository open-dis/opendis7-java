package edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.OverheadCoveredInfantryPosition;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class OverheadCoveredInfantryPosition extends ObjectType
{
    public OverheadCoveredInfantryPosition()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(2)); // Prepared position
        setCategory((byte)2); // Infantry Fighting Position
        setSubCategory((byte)2); // Overhead Covered Infantry Position
    }
}
