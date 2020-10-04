package edu.nps.moves.dis7.entities.usa.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1a536164
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 19726
 */
public class Mod6 extends EntityType
{
    public Mod6()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 19689, Guided
        setSubCategory((byte)13); // uid 19724, ADCAP
        setSpecific((byte)2); // uid 19726, Mod 6
    }
}
