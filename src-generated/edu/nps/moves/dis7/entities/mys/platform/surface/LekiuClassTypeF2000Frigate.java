package edu.nps.moves.dis7.entities.mys.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@410954b
 * Country: Malaysia (MYS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30508
 */
public class LekiuClassTypeF2000Frigate extends EntityType
{
    public LekiuClassTypeF2000Frigate()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27399, Guided Missile Frigate (FFG)
        setSubCategory((byte)2); // uid 30508, Lekiu Class (Type F2000 Frigate)
    }
}
