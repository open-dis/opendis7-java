package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Pump.Pump_Gas;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Pump_Gas extends ObjectType
{
    public Pump_Gas()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)12); // Pump
        setSubCategory((byte)1); // Pump, Gas
    }
}
