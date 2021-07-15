package edu.nps.moves.dis7.entities.deu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@13df2a8c;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 16332
 */
public class EFMEnhancedFighterManeuverabilityX31A extends EntityType
{
    /** Default constructor */
    public EFMEnhancedFighterManeuverabilityX31A()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 16328, Fighter/Air Defense
        setSubCategory((byte)4); // uid 16332, EFM (Enhanced Fighter Maneuverability) X-31A
    }
}
