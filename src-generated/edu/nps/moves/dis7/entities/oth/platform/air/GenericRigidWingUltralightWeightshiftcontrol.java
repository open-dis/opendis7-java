package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@27f3b6d6
 * Country: Other
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24686
 */
public class GenericRigidWingUltralightWeightshiftcontrol extends EntityType
{
    public GenericRigidWingUltralightWeightshiftcontrol()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)81); // uid 24685, Civilian Ultralight Aircraft, Rigid Wing
        setSubCategory((byte)1); // uid 24686, Generic Rigid Wing Ultralight, Weight-shift control
    }
}
