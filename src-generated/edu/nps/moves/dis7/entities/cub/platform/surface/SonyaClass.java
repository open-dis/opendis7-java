package edu.nps.moves.dis7.entities.cub.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@38c6f217;
 * Country: Cuba (CUB);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 29970
 */
public class SonyaClass extends EntityType
{
    /** Default constructor */
    public SonyaClass()
    {
        setCountry(Country.STOP_FREEZE_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29969, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 29970, Sonya Class
    }
}
