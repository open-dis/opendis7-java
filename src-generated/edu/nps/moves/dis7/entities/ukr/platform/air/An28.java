package edu.nps.moves.dis7.entities.ukr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@31c628e7
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29236
 */
public class An28 extends EntityType
{
    public An28()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)86); // uid 29233, Civilian Fixed Wing Aircraft, Medium (up to 41,000 lbs / 18,597 kg)
        setSubCategory((byte)22); // uid 29234, Twin Engine Turboprop
        setSpecific((byte)1); // uid 29235, Antonov An-28
        setExtra((byte)1); // uid 29236, An-28
    }
}
