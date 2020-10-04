package edu.nps.moves.dis7.entities.bhs.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@12843fce
 * Country: Bahamas (BHS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24483
 */
public class ContainerShip extends EntityType
{
    public ContainerShip()
    {
        setCountry(Country.BAHAMAS_BHS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24482, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 24483, Container Ship
    }
}
