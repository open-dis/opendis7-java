package edu.nps.moves.dis7.entities.lbn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@22c86919;
 * Country: Lebanon (LBN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 17980
 */
public class TrackerMk2coastalpatrolcraft extends EntityType
{
    /** Default constructor */
    public TrackerMk2coastalpatrolcraft()
    {
        setCountry(Country.LEBANON_LBN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 17979, Light/Patrol Craft
        setSubCategory((byte)1); // uid 17980, Tracker Mk2 (coastal patrol craft)
    }
}
