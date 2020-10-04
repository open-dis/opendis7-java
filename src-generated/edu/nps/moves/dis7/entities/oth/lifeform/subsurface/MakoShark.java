package edu.nps.moves.dis7.entities.oth.lifeform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7f5e6833
 * Country: Other
 * Entity kind: Life form
 * Domain: SUBSURFACE
 *
 * Entity type uid: 32265
 */
public class MakoShark extends EntityType
{
    public MakoShark()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)200); // uid 32263, Fish
        setSubCategory((byte)121); // uid 32265, Mako Shark
    }
}
