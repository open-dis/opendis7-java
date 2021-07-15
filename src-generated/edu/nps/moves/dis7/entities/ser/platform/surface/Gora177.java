package edu.nps.moves.dis7.entities.ser.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@295bf2a;
 * Country: Serbia and Montenegro;
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 19077
 */
public class Gora177 extends EntityType
{
    /** Default constructor */
    public Gora177()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19072, Light/Patrol Craft
        setSubCategory((byte)2); // uid 19074, Mirna Class Type 140 PCF
        setSpecific((byte)3); // uid 19077, Gora 177
    }
}
