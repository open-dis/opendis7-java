package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LightweightMaintenanceEnclosureLME_M1;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class LightweightMaintenanceEnclosureLME_M1 extends ObjectType
{
    public LightweightMaintenanceEnclosureLME_M1()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)6); // Maintenance Structure
        setSubCategory((byte)2); // Lightweight Maintenance Enclosure (LME), M1
    }
}
