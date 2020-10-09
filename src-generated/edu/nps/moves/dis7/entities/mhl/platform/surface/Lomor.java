package edu.nps.moves.dis7.entities.mhl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1b9ea3e3
 * Country: Marshall Islands (MHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26709
 */
public class Lomor extends EntityType
{
    public Lomor()
    {
        setCountry(Country.MARSHALL_ISLANDS_MHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26707, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26708, Pacific Class Patrol Boat
        setSpecific((byte)1); // uid 26709, Lomor
    }
}
