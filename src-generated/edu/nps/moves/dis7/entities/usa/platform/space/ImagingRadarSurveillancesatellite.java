package edu.nps.moves.dis7.entities.usa.platform.space;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@73bb1337;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: SPACE;
 *
 * Entity type uid: 12459
 */
public class ImagingRadarSurveillancesatellite extends EntityType
{
    /** Default constructor */
    public ImagingRadarSurveillancesatellite()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SPACE));

        setCategory((byte)2); // uid 12431, Unmanned
        setSubCategory((byte)7); // uid 12459, Imaging Radar Surveillance satellite
    }
}