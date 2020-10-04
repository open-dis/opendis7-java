package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2f19f2aa
 * Country: Other
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24680
 */
public class GenericHangGliderUnpowered extends EntityType
{
    public GenericHangGliderUnpowered()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)80); // uid 24679, Civilian Ultralight Aircraft, Non-rigid Wing
        setSubCategory((byte)1); // uid 24680, Generic Hang Glider, Unpowered
    }
}
