package edu.nps.moves.dis7.entities.esp.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1d23ff23
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28397
 */
public class HC144AOceanSentry extends EntityType
{
    public HC144AOceanSentry()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 18999, Cargo/Tanker
        setSubCategory((byte)3); // uid 24759, CASA CN-235
        setSpecific((byte)1); // uid 28397, HC-144A Ocean Sentry
    }
}
