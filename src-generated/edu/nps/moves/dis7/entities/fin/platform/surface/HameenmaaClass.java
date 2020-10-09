package edu.nps.moves.dis7.entities.fin.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@548e6d58
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23028
 */
public class HameenmaaClass extends EntityType
{
    public HameenmaaClass()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 23027, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 23028, Hameenmaa Class
    }
}
