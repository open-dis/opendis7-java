package edu.nps.moves.dis7.entities.usa.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@4844930a;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28474
 */
public class Interim39ftMidnightExpress extends EntityType
{
    /** Default constructor */
    public Interim39ftMidnightExpress()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)87); // uid 28469, Other Vessels
        setSubCategory((byte)1); // uid 28470, Go-Fast Boat
        setSpecific((byte)1); // uid 28471, U.S. Customs and Border Patrol (CBP) Interceptor Class
        setExtra((byte)3); // uid 28474, Interim 39ft Midnight Express
    }
}