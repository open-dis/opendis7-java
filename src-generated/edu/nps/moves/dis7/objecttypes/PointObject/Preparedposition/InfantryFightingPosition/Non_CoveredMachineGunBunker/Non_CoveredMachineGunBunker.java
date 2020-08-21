package edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.Non_CoveredMachineGunBunker;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Non_CoveredMachineGunBunker extends ObjectType
{
    public Non_CoveredMachineGunBunker()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(2)); // Prepared position
        setCategory((byte)2); // Infantry Fighting Position
        setSubCategory((byte)4); // Non-Covered Machine Gun Bunker
    }
}
