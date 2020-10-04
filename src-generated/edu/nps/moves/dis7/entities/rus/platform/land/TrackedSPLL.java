package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@562c877a
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 13110
 */
public class TrackedSPLL extends EntityType
{
    public TrackedSPLL()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)11); // uid 13103, SA-17 Grizzly SAM System
        setSpecific((byte)4); // uid 13109, SA-17 Launcher/Loader Vehicle (TEL)
        setExtra((byte)1); // uid 13110, Tracked (SP) LL
    }
}
