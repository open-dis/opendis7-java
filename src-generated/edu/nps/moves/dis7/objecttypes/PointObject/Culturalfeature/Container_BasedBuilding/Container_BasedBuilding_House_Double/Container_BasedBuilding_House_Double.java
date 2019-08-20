package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_House_Double;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Container_BasedBuilding_House_Double extends ObjectType
{
    public Container_BasedBuilding_House_Double()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)8); // Container-Based Building
        setSubCategory((byte)4); // Container-Based Building, House, Double
    }
}
