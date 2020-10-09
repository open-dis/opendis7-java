package edu.nps.moves.dis7.entities.cyp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@459e9125
 * Country: Cyprus (CYP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24502
 */
public class ContainerShip extends EntityType
{
    public ContainerShip()
    {
        setCountry(Country.CYPRUS_CYP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24501, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 24502, Container Ship
    }
}
