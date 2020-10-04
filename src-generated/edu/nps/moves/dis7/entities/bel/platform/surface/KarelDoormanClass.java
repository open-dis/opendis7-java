package edu.nps.moves.dis7.entities.bel.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7dc7cbad
 * Country: Belgium (BEL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23321
 */
public class KarelDoormanClass extends EntityType
{
    public KarelDoormanClass()
    {
        setCountry(Country.BELGIUM_BEL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 23320, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 23321, Karel Doorman Class
    }
}
