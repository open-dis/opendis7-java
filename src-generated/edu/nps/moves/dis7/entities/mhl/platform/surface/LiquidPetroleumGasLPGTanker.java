package edu.nps.moves.dis7.entities.mhl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3f093abe;
 * Country: Marshall Islands (MHL);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24573
 */
public class LiquidPetroleumGasLPGTanker extends EntityType
{
    /** Default constructor */
    public LiquidPetroleumGasLPGTanker()
    {
        setCountry(Country.MARSHALL_ISLANDS_MHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24572, Tanker (Group 3 Merchant)
        setSubCategory((byte)1); // uid 24573, Liquid Petroleum Gas (LPG)Tanker
    }
}
