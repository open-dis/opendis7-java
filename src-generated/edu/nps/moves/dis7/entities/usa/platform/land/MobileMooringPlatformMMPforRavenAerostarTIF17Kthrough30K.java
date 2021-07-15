package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4091b9c3;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 26939
 */
public class MobileMooringPlatformMMPforRavenAerostarTIF17Kthrough30K extends EntityType
{
    /** Default constructor */
    public MobileMooringPlatformMMPforRavenAerostarTIF17Kthrough30K()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)89); // uid 26937, Trailer
        setSubCategory((byte)23); // uid 26938, Trailer, Aerostat Mooring Platform
        setSpecific((byte)1); // uid 26939, Mobile Mooring Platform (MMP) for Raven Aerostar TIF-(17K through 30K)
    }
}
