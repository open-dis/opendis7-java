package edu.nps.moves.dis7.entities.chn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@212fafd1
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32414
 */
public class CSS5Mod2SecondStageVehicle extends EntityType
{
    public CSS5Mod2SecondStageVehicle()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32412, Guided
        setSubCategory((byte)1); // uid 32413, CSS-5 Mod-2 (DF-21A)
        setSpecific((byte)1); // uid 32414, CSS-5 Mod-2 Second Stage Vehicle
    }
}
