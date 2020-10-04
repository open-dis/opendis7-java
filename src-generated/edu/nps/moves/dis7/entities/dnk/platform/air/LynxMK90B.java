package edu.nps.moves.dis7.entities.dnk.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@408d971b
 * Country: Denmark (DNK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 25520
 */
public class LynxMK90B extends EntityType
{
    public LynxMK90B()
    {
        setCountry(Country.DENMARK_DNK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 25519, Anti-Submarine Warfare/Patrol Helicopter
        setSubCategory((byte)1); // uid 25520, Lynx MK-90B
    }
}
