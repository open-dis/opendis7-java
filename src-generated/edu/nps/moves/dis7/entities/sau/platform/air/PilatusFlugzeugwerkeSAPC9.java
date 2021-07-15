package edu.nps.moves.dis7.entities.sau.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@8f2098e;
 * Country: Saudi Arabia (SAU);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 17846
 */
public class PilatusFlugzeugwerkeSAPC9 extends EntityType
{
    /** Default constructor */
    public PilatusFlugzeugwerkeSAPC9()
    {
        setCountry(Country.SAUDI_ARABIA_SAU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 17845, Trainer
        setSubCategory((byte)1); // uid 17846, Pilatus Flugzeugwerke SA PC-9
    }
}
