package edu.nps.moves.dis7.entities.che.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@455c1d8c
 * Country: Switzerland (CHE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19047
 */
public class PilatusPC6TurboPorter extends EntityType
{
    public PilatusPC6TurboPorter()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 19045, Cargo / Tanker
        setSubCategory((byte)1); // uid 19046, Pilatus PC-6
        setSpecific((byte)1); // uid 19047, Pilatus PC-6 Turbo Porter
    }
}
