package edu.nps.moves.dis7.entities.nzl.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@66238be2;
 * Country: New Zealand (NZL);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31939
 */
public class HighMobilityTransporterHMTNZ extends EntityType
{
    /** Default constructor */
    public HighMobilityTransporterHMTNZ()
    {
        setCountry(Country.NEW_ZEALAND_NZL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 31938, Small Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 31939, High Mobility Transporter (HMT) (NZ)
    }
}
