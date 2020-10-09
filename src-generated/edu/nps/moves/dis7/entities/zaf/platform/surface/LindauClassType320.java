package edu.nps.moves.dis7.entities.zaf.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2c7a8af2
 * Country: South Africa (ZAF)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27560
 */
public class LindauClassType320 extends EntityType
{
    public LindauClassType320()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27559, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27560, Lindau Class (Type 320)
    }
}
