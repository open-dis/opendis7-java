package edu.nps.moves.dis7.entities.mys.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@10b892d5
 * Country: Malaysia (MYS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 26251
 */
public class ScorpeneClass extends EntityType
{
    public ScorpeneClass()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 26250, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 26251, Scorpene Class
    }
}
