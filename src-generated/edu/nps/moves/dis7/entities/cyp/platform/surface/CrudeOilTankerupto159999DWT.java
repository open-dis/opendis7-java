package edu.nps.moves.dis7.entities.cyp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4d5d943d
 * Country: Cyprus (CYP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24505
 */
public class CrudeOilTankerupto159999DWT extends EntityType
{
    public CrudeOilTankerupto159999DWT()
    {
        setCountry(Country.CYPRUS_CYP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24504, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 24505, Crude Oil Tanker (up to 159,999 DWT)
    }
}
