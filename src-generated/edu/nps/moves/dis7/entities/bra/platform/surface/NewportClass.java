package edu.nps.moves.dis7.entities.bra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@490ab905
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 32636
 */
public class NewportClass extends EntityType
{
    public NewportClass()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 32635, Tank Landing Ship
        setSubCategory((byte)1); // uid 32636, Newport Class
    }
}
