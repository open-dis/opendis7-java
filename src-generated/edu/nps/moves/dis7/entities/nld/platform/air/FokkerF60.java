package edu.nps.moves.dis7.entities.nld.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@24be2d9c
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28196
 */
public class FokkerF60 extends EntityType
{
    public FokkerF60()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 18933, Cargo/Tanker
        setSubCategory((byte)2); // uid 28194, Fokker F50/F60 Family
        setSpecific((byte)2); // uid 28196, Fokker F60
    }
}
