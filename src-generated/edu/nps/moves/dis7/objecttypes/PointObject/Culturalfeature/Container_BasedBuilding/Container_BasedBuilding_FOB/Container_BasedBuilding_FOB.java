package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_FOB;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Container_BasedBuilding_FOB extends ObjectType
{
    public Container_BasedBuilding_FOB()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)8); // Container-Based Building
        setSubCategory((byte)7); // Container-Based Building, FOB
    }
}
