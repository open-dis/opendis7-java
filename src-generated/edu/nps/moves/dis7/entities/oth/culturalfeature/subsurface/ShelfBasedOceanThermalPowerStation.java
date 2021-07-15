package edu.nps.moves.dis7.entities.oth.culturalfeature.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5560b64d;
 * Country: Other;
 * Entity kind: Cultural feature;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 29786
 */
public class ShelfBasedOceanThermalPowerStation extends EntityType
{
    /** Default constructor */
    public ShelfBasedOceanThermalPowerStation()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 29783, Electrical Power Installation
        setSubCategory((byte)2); // uid 29785, Ocean Thermal Power Station
        setSpecific((byte)1); // uid 29786, Shelf Based Ocean Thermal Power Station
    }
}
