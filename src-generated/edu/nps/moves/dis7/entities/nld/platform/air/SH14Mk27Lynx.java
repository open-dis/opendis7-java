package edu.nps.moves.dis7.entities.nld.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@70d2e40b
 * Country: Netherlands (NLD)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 18936
 */
public class SH14Mk27Lynx extends EntityType
{
    public SH14Mk27Lynx()
    {
        setCountry(Country.NETHERLANDS_NLD);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 18935, Utility Helicopter
        setSubCategory((byte)1); // uid 18936, SH 14 (Mk27 Lynx)
    }
}
