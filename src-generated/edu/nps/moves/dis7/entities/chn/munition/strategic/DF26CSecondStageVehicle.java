package edu.nps.moves.dis7.entities.chn.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@231cdda8
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32813
 */
public class DF26CSecondStageVehicle extends EntityType
{
    public DF26CSecondStageVehicle()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21556, Guided
        setSubCategory((byte)44); // uid 32812, DF-26C
        setSpecific((byte)1); // uid 32813, DF-26C Second Stage Vehicle
    }
}
