package edu.nps.moves.dis7.entities.kwt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@61d9efe0
 * Country: Kuwait (KWT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24444
 */
public class LiquidPetroleumGasLPGTanker extends EntityType
{
    public LiquidPetroleumGasLPGTanker()
    {
        setCountry(Country.KUWAIT_KWT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24443, Tanker (Group 3 Merchant)
        setSubCategory((byte)1); // uid 24444, Liquid Petroleum Gas (LPG)Tanker
    }
}
