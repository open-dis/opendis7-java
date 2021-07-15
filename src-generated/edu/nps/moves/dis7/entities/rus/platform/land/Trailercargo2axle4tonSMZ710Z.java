package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@63e5e5b4;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 12992
 */
public class Trailercargo2axle4tonSMZ710Z extends EntityType
{
    /** Default constructor */
    public Trailercargo2axle4tonSMZ710Z()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)14); // uid 12987, Cargo Trailer
        setSubCategory((byte)3); // uid 12991, 2.01 - 5 ton
        setSpecific((byte)1); // uid 12992, Trailer, cargo, 2 axle, 4 ton, SMZ-710Z
    }
}
