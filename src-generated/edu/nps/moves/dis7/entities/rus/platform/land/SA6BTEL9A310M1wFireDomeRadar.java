package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@53692008
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 13072
 */
public class SA6BTEL9A310M1wFireDomeRadar extends EntityType
{
    public SA6BTEL9A310M1wFireDomeRadar()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)6); // uid 13068, SA-6 Gainful SAM System
        setSpecific((byte)2); // uid 13070, SA-6 TEL
        setExtra((byte)2); // uid 13072, SA-6B TEL (9A310M1 w/Fire Dome Radar)
    }
}
