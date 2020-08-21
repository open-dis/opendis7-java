package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Container_BasedBuilding extends ObjectType
{
    public Container_BasedBuilding()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)8); // Container-Based Building
    }
}
