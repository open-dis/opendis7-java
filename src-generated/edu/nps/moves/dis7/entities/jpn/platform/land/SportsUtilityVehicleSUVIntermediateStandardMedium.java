package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@42f3156d
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24873
 */
public class SportsUtilityVehicleSUVIntermediateStandardMedium extends EntityType
{
    public SportsUtilityVehicleSUVIntermediateStandardMedium()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)81); // uid 24863, Car
        setSubCategory((byte)113); // uid 24873, Sports Utility Vehicle (SUV), Intermediate/Standard (Medium)
    }
}
