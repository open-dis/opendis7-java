package edu.nps.moves.dis7.entities.oth.culturalfeature.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@70d5d96b
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: LAND
 *
 * Entity type uid: 31427
 */
public class FlatRoofAircraftShelter extends EntityType
{
    public FlatRoofAircraftShelter()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 21953, Building
        setSubCategory((byte)1); // uid 21955, One-story
        setSpecific((byte)5); // uid 31427, Flat Roof Aircraft Shelter
    }
}
