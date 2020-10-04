package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5d235104
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 12989
 */
public class Trailercargo1axle05tonGAZ704 extends EntityType
{
    public Trailercargo1axle05tonGAZ704()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)14); // uid 12987, Cargo Trailer
        setSubCategory((byte)1); // uid 12988, 0 - 0.5 ton
        setSpecific((byte)1); // uid 12989, Trailer, cargo, 1 axle, 0.5 ton, GAZ-704
    }
}
