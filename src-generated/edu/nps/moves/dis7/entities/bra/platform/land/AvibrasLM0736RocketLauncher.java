package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@100fc185;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 32033
 */
public class AvibrasLM0736RocketLauncher extends EntityType
{
    /** Default constructor */
    public AvibrasLM0736RocketLauncher()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 32032, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)1); // uid 32033, Avibras LM-07/36 Rocket Launcher
    }
}
