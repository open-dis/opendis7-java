package edu.nps.moves.dis7.entities.usa.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@286855ea;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 26936
 */
public class RavenAerostarTIF25K extends EntityType
{
    /** Default constructor */
    public RavenAerostarTIF25K()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)100); // uid 26934, Civilian Lighter than Air, Balloon
        setSubCategory((byte)2); // uid 26935, Gas-filled, tethered
        setSpecific((byte)1); // uid 26936, Raven Aerostar TIF-25K
    }
}
