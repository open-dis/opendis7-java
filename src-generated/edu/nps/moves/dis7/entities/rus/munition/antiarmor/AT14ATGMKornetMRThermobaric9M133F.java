package edu.nps.moves.dis7.entities.rus.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@61a87366;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: ANTI_ARMOR;
 *
 * Entity type uid: 23989
 */
public class AT14ATGMKornetMRThermobaric9M133F extends EntityType
{
    /** Default constructor */
    public AT14ATGMKornetMRThermobaric9M133F()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)1); // uid 20421, Guided
        setSubCategory((byte)15); // uid 20442, AT-14
        setSpecific((byte)4); // uid 23989, AT-14 ATGM, Kornet-MR Thermobaric (9M133F)
    }
}
