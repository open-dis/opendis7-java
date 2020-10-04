package edu.nps.moves.dis7.entities.pol.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@547c04c4
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24802
 */
public class PZLMielecM28Skytruck extends EntityType
{
    public PZLMielecM28Skytruck()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 24801, Cargo/Tanker
        setSubCategory((byte)1); // uid 24802, PZL-Mielec M28 Skytruck
    }
}
