package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4d0b0fd4;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 25364
 */
public class GraveStoneEngagementRadar92N2E extends EntityType
{
    /** Default constructor */
    public GraveStoneEngagementRadar92N2E()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)24); // uid 25360, SA-21 Growler SAM System (S-400 Triumf)
        setSpecific((byte)4); // uid 25364, Grave Stone Engagement Radar (92N2E)
    }
}
