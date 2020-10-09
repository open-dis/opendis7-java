package edu.nps.moves.dis7.entities.cze.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@235834f2
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30086
 */
public class AeroL159ALCA extends EntityType
{
    public AeroL159ALCA()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 30085, Fighter/Air Defense
        setSubCategory((byte)1); // uid 30086, Aero L-159 ALCA
    }
}
