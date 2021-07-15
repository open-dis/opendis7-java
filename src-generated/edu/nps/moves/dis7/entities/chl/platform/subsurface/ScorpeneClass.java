package edu.nps.moves.dis7.entities.chl.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@58c1670b;
 * Country: Chile (CHL);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 26246
 */
public class ScorpeneClass extends EntityType
{
    /** Default constructor */
    public ScorpeneClass()
    {
        setCountry(Country.CHILE_CHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 26245, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 26246, Scorpene Class
    }
}
