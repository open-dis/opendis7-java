package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@10b687f2;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 25349
 */
public class _4DoorSedanFullPremiumLuxuryLarge extends EntityType
{
    /** Default constructor */
    public _4DoorSedanFullPremiumLuxuryLarge()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)81); // uid 24919, Car
        setSubCategory((byte)44); // uid 25349, 4-Door Sedan, Full/Premium/Luxury (Large)
    }
}
