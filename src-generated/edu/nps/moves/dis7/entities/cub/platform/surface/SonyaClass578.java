package edu.nps.moves.dis7.entities.cub.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@31304f14
 * Country: Cuba (CUB)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29974
 */
public class SonyaClass578 extends EntityType
{
    public SonyaClass578()
    {
        setCountry(Country.CUBA_CUB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29969, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 29970, Sonya Class
        setSpecific((byte)4); // uid 29974, 578
    }
}
