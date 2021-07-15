package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7165d530;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 24101
 */
public class M60MBTwArmoredVehicleLaunchedMICLICAVLM extends EntityType
{
    /** Default constructor */
    public M60MBTwArmoredVehicleLaunchedMICLICAVLM()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 10018, Tank
        setSubCategory((byte)2); // uid 10029, M60 Main Battle Tank (MBT)
        setSpecific((byte)5); // uid 24101, M60 MBT w/ Armored Vehicle Launched MICLIC (AVLM)
    }
}
