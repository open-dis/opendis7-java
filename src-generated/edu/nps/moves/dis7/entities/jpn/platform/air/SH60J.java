package edu.nps.moves.dis7.entities.jpn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2cac4385;
 * Country: Japan (JPN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 33007
 */
public class SH60J extends EntityType
{
    /** Default constructor */
    public SH60J()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 33005, Anti-Submarine Warfare/Patrol Helicopter
        setSubCategory((byte)1); // uid 33006, Mitsubishi H-60
        setSpecific((byte)1); // uid 33007, SH-60J
    }
}
