package edu.nps.moves.dis7.entities.egy.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@45c7e403;
 * Country: Egypt (EGY);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26763
 */
public class MHC521AlSiddiq extends EntityType
{
    /** Default constructor */
    public MHC521AlSiddiq()
    {
        setCountry(Country.COMMENT_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 26761, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 26762, Coastal Minehunter Class
        setSpecific((byte)1); // uid 26763, MHC 521 Al Siddiq
    }
}
