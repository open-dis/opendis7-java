package edu.nps.moves.dis.objecttypes.PointObject.Culturalfeature.IndustrialProcessingPlant;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class IndustrialProcessingPlant extends ObjectType
{
    public IndustrialProcessingPlant()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)13); // Industrial Processing Plant
    }
}
