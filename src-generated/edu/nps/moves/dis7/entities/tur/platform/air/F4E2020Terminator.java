package edu.nps.moves.dis7.entities.tur.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4dba773d
 * Country: Turkey (TUR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30596
 */
public class F4E2020Terminator extends EntityType
{
    public F4E2020Terminator()
    {
        setCountry(Country.TURKEY_TUR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 30593, Fighter/Air Defense
        setSubCategory((byte)1); // uid 30594, McDonnell-Douglas F-4 Phantom II
        setSpecific((byte)2); // uid 30596, F-4E 2020 Terminator
    }
}
