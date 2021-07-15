package edu.nps.moves.dis7.entities.usa.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@4391a2d8;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28314
 */
public class EricksonS64EAircrane extends EntityType
{
    /** Default constructor */
    public EricksonS64EAircrane()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)92); // uid 26282, Civilian Helicopter, Large (above 20,000 lbs / 9,072 kg)
        setSubCategory((byte)12); // uid 26283, Single Rotor, Turboshaft Engine, Conventional Tail Rotor
        setSpecific((byte)3); // uid 28313, Sikorsky S-64 Skycrane
        setExtra((byte)1); // uid 28314, Erickson S-64E Aircrane
    }
}
