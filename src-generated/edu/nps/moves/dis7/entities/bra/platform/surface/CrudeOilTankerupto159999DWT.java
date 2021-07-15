package edu.nps.moves.dis7.entities.bra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@91161c7;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31878
 */
public class CrudeOilTankerupto159999DWT extends EntityType
{
    /** Default constructor */
    public CrudeOilTankerupto159999DWT()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 31789, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 31878, Crude Oil Tanker (up to 159,999 DWT)
    }
}
