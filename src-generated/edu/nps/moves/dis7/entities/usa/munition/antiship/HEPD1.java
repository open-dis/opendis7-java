package edu.nps.moves.dis7.entities.usa.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@793cef95
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 19745
 */
public class HEPD1 extends EntityType
{
    public HEPD1()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)2); // uid 19729, Ballistic
        setSubCategory((byte)3); // uid 19742, 76 mm
        setSpecific((byte)3); // uid 19745, HE-PD
    }
}
