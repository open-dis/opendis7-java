package edu.nps.moves.dis7.entities.dza.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7aec35a;
 * Country: Algeria (DZA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27731
 */
public class MouradRaisClass extends EntityType
{
    /** Default constructor */
    public MouradRaisClass()
    {
        setCountry(Country.ALGERIA_DZA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27048, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 27731, Mourad Rais Class
    }
}