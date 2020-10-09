package edu.nps.moves.dis7.entities.oth.radio.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2e93108a
 * Country: Other
 * Entity kind: Radio
 * Domain: SURFACE
 *
 * Entity type uid: 31911
 */
public class Other extends EntityType
{
    public Other()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)37); // uid 31910, Automatic Identification System (AIS)
        setSubCategory((byte)0); // uid 31911, Other
    }
}
