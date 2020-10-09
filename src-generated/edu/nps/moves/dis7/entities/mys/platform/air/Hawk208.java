package edu.nps.moves.dis7.entities.mys.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@544630b7
 * Country: Malaysia (MYS)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28557
 */
public class Hawk208 extends EntityType
{
    public Hawk208()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 28555, Attack/Strike
        setSubCategory((byte)1); // uid 28556, BAE Systems Hawk
        setSpecific((byte)1); // uid 28557, Hawk 208
    }
}
