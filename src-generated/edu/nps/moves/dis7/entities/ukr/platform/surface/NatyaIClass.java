package edu.nps.moves.dis7.entities.ukr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6c841199
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29869
 */
public class NatyaIClass extends EntityType
{
    public NatyaIClass()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29868, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 29869, Natya I Class
    }
}
