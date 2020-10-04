package edu.nps.moves.dis7.entities.bra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5622fdf
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 32099
 */
public class AF1B extends EntityType
{
    public AF1B()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 25694, Attack/Strike
        setSubCategory((byte)2); // uid 32096, McDonnell-Douglas A-4 Skyhawk
        setSpecific((byte)3); // uid 32099, AF-1B
    }
}
