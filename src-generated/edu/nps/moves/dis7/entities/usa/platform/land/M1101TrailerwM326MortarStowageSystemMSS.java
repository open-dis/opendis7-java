package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@fa5f81c
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 28355
 */
public class M1101TrailerwM326MortarStowageSystemMSS extends EntityType
{
    public M1101TrailerwM326MortarStowageSystemMSS()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)14); // uid 10616, Cargo Trailer
        setSubCategory((byte)2); // uid 10618, 0.51 - 2 ton
        setSpecific((byte)2); // uid 25284, Trailer, Cargo, High Mobility, 3/4 ton, M1101
        setExtra((byte)1); // uid 28355, M1101 Trailer w/ M326 Mortar Stowage System (MSS)
    }
}
