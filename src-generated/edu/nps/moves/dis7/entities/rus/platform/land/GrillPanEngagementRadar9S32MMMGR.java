package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@3e850122
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29861
 */
public class GrillPanEngagementRadar9S32MMMGR extends EntityType
{
    public GrillPanEngagementRadar9S32MMMGR()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)26); // uid 29855, SA-23 Gladiator/Giant SAM System (S-300VM/Antey-2500)
        setSpecific((byte)2); // uid 29860, SA-23 Multichannel Missile Guidance Station (MMGS)
        setExtra((byte)1); // uid 29861, Grill Pan Engagement Radar (9S32M MMGR)
    }
}
