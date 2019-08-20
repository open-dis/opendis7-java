package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.MicrowaveTower;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class MicrowaveTower extends ObjectType
{
    public MicrowaveTower()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)1); // Building / Structure
        setSubCategory((byte)6); // Microwave Tower
    }
}
