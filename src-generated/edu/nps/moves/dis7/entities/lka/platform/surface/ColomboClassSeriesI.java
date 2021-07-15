package edu.nps.moves.dis7.entities.lka.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7d04529c;
 * Country: Sri Lanka (LKA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26424
 */
public class ColomboClassSeriesI extends EntityType
{
    /** Default constructor */
    public ColomboClassSeriesI()
    {
        setCountry(Country.SRI_LANKA_LKA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26422, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26423, Colombo Class Ultra Fast Attack Craft
        setSpecific((byte)1); // uid 26424, Colombo Class Series I
    }
}
