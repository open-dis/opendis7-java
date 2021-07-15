package edu.nps.moves.dis7.entities.tur.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6caf7803;
 * Country: Turkey (TUR);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 30599
 */
public class RF4E extends EntityType
{
    /** Default constructor */
    public RF4E()
    {
        setCountry(Country.TURKEY_TUR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)7); // uid 30597, Reconnaissance
        setSubCategory((byte)1); // uid 30598, McDonnell-Douglas F-4 Phantom II
        setSpecific((byte)1); // uid 30599, RF-4E
    }
}
