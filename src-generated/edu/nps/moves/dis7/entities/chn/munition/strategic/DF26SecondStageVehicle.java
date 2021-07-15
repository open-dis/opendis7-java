package edu.nps.moves.dis7.entities.chn.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@48d739f;
 * Country: China, Peoples Republic of (CHN);
 * Entity kind: Munition;
 * Domain: STRATEGIC;
 *
 * Entity type uid: 32784
 */
public class DF26SecondStageVehicle extends EntityType
{
    /** Default constructor */
    public DF26SecondStageVehicle()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21556, Guided
        setSubCategory((byte)43); // uid 32783, DF-26
        setSpecific((byte)1); // uid 32784, DF-26 Second Stage Vehicle
    }
}