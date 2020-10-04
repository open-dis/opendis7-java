package edu.nps.moves.dis7.entities.cze.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@71d44a3
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30093
 */
public class LetL410Turbolet extends EntityType
{
    public LetL410Turbolet()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 30092, Cargo/Tanker
        setSubCategory((byte)1); // uid 30093, Let L-410 Turbolet
    }
}
