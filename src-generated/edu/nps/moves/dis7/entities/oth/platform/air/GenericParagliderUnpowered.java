package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6a078481
 * Country: Other
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24682
 */
public class GenericParagliderUnpowered extends EntityType
{
    public GenericParagliderUnpowered()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)80); // uid 24679, Civilian Ultralight Aircraft, Non-rigid Wing
        setSubCategory((byte)3); // uid 24682, Generic Paraglider, Unpowered
    }
}
