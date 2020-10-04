package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@f14e5bf
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 13055
 */
public class SA10ATowedTEL5P85T extends EntityType
{
    public SA10ATowedTEL5P85T()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)4); // uid 13052, SA-10 Grumble SAM System
        setSpecific((byte)2); // uid 13054, SA-10 Missile Launcher
        setExtra((byte)1); // uid 13055, SA-10A Towed TEL (5P85T)
    }
}
