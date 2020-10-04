package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@4c27d39d
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 13094
 */
public class SA12BGiantTELAR9A82 extends EntityType
{
    public SA12BGiantTELAR9A82()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)9); // uid 13086, SA-12 Gladiator/Giant SAM System (S-300V)
        setSpecific((byte)2); // uid 13091, Battery
        setExtra((byte)3); // uid 13094, SA-12B Giant TELAR (9A82)
    }
}
