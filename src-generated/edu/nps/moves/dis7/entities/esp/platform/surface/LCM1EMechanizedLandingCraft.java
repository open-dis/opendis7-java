package edu.nps.moves.dis7.entities.esp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@9b21bd3
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29445
 */
public class LCM1EMechanizedLandingCraft extends EntityType
{
    public LCM1EMechanizedLandingCraft()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 29444, Landing Craft
        setSubCategory((byte)1); // uid 29445, LCM-1E Mechanized Landing Craft
    }
}
