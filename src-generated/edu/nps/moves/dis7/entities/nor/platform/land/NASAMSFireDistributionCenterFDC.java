package edu.nps.moves.dis7.entities.nor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@473b3b7a;
 * Country: Norway (NOR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 30281
 */
public class NASAMSFireDistributionCenterFDC extends EntityType
{
    /** Default constructor */
    public NASAMSFireDistributionCenterFDC()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 30278, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)1); // uid 30279, Norwegian Advanced Surface to Air Missile System (NASAMS)
        setSpecific((byte)2); // uid 30281, NASAMS Fire Distribution Center (FDC)
    }
}
