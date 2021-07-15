package edu.nps.moves.dis7.entities.ita.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@655f7ea;
 * Country: Italy (ITA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29174
 */
public class SIAIMarchettiSF260AleniaAermacchiSF260 extends EntityType
{
    /** Default constructor */
    public SIAIMarchettiSF260AleniaAermacchiSF260()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 24760, Trainer
        setSubCategory((byte)3); // uid 29174, SIAI-Marchetti SF.260 / Alenia Aermacchi SF-260
    }
}
