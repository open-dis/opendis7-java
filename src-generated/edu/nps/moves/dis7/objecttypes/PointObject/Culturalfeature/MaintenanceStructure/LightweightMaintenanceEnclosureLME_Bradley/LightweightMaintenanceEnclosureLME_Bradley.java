package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LightweightMaintenanceEnclosureLME_Bradley;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class LightweightMaintenanceEnclosureLME_Bradley extends ObjectType
{
    public LightweightMaintenanceEnclosureLME_Bradley()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)6); // Maintenance Structure
        setSubCategory((byte)1); // Lightweight Maintenance Enclosure (LME), Bradley
    }
}
