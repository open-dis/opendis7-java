package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.FOB_GuardTower;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class FOB_GuardTower extends ObjectType
{
    public FOB_GuardTower()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)1); // Building / Structure
        setSubCategory((byte)17); // FOB, Guard Tower
    }
}
