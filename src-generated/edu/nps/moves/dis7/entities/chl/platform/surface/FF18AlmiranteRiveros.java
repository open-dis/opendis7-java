package edu.nps.moves.dis7.entities.chl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@66d1af89
 * Country: Chile (CHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27466
 */
public class FF18AlmiranteRiveros extends EntityType
{
    public FF18AlmiranteRiveros()
    {
        setCountry(Country.CHILE_CHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27464, Guided Missile Frigate (FFG)
        setSubCategory((byte)3); // uid 27465, Karel Doorman Class
        setSpecific((byte)1); // uid 27466, FF-18 Almirante Riveros
    }
}
