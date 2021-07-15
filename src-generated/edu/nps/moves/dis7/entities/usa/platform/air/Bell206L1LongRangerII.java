package edu.nps.moves.dis7.entities.usa.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@7e34b127;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 26418
 */
public class Bell206L1LongRangerII extends EntityType
{
    /** Default constructor */
    public Bell206L1LongRangerII()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)90); // uid 26410, Civilian Helicopter, Small (up to 7,000 lbs / 3,175 kg)
        setSubCategory((byte)12); // uid 26411, Single Rotor, Turboshaft Engine, Conventional Tail Rotor
        setSpecific((byte)1); // uid 26412, Bell 206
        setExtra((byte)6); // uid 26418, Bell 206L-1 Long Ranger II
    }
}