package edu.nps.moves.dis7.entities.bra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@13805618
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 32638
 */
public class AmphibiousCargoShip extends EntityType
{
    public AmphibiousCargoShip()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)55); // uid 32638, Amphibious Cargo Ship
    }
}
