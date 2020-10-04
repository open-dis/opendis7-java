package edu.nps.moves.dis7.entities.pan.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@60c16548
 * Country: Panama (PAN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24568
 */
public class LiquidPetroleumGasLPGTanker extends EntityType
{
    public LiquidPetroleumGasLPGTanker()
    {
        setCountry(Country.PANAMA_PAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24556, Tanker (Group 3 Merchant)
        setSubCategory((byte)1); // uid 24568, Liquid Petroleum Gas (LPG)Tanker
    }
}
