package edu.nps.moves.dis7.entities.arg.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@18769467;
 * Country: Argentina (ARG);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29148
 */
public class FMAIA58Pucara extends EntityType
{
    /** Default constructor */
    public FMAIA58Pucara()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 29147, Attack/Strike
        setSubCategory((byte)1); // uid 29148, FMA IA 58 Pucara
    }
}
