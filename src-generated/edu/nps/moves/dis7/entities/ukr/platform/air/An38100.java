package edu.nps.moves.dis7.entities.ukr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@8bd86c8
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29243
 */
public class An38100 extends EntityType
{
    public An38100()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)86); // uid 29233, Civilian Fixed Wing Aircraft, Medium (up to 41,000 lbs / 18,597 kg)
        setSubCategory((byte)22); // uid 29234, Twin Engine Turboprop
        setSpecific((byte)3); // uid 29242, Antonov An-38
        setExtra((byte)1); // uid 29243, An-38-100
    }
}
