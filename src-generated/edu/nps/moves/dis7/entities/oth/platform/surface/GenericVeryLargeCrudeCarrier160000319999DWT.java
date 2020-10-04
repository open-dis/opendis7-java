package edu.nps.moves.dis7.entities.oth.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4a325eb9
 * Country: Other
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26949
 */
public class GenericVeryLargeCrudeCarrier160000319999DWT extends EntityType
{
    public GenericVeryLargeCrudeCarrier160000319999DWT()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24627, Tanker (Group 3 Merchant)
        setSubCategory((byte)7); // uid 26949, Generic Very Large Crude Carrier (160,000-319,999 DWT)
    }
}
