package edu.nps.moves.dis7.entities.pak.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@79e10fb4;
 * Country: Pakistan (PAK);
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 29048
 */
public class HatfVIIHaft7Babur extends EntityType
{
    /** Default constructor */
    public HatfVIIHaft7Babur()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)1); // uid 29047, Guided
        setSubCategory((byte)1); // uid 29048, Hatf-VII / Haft-7 (Babur)
    }
}
