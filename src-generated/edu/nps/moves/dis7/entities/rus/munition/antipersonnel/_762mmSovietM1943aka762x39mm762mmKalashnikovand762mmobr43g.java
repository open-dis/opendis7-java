package edu.nps.moves.dis7.entities.rus.munition.antipersonnel;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@539fc5d1
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: ANTI_PERSONNEL
 *
 * Entity type uid: 20644
 */
public class _762mmSovietM1943aka762x39mm762mmKalashnikovand762mmobr43g extends EntityType
{
    public _762mmSovietM1943aka762x39mm762mmKalashnikovand762mmobr43g()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_PERSONNEL));

        setCategory((byte)2); // uid 20637, Ballistic
        setSubCategory((byte)2); // uid 20641, 7.62 mm
        setSpecific((byte)3); // uid 20644, 7.62-mm Soviet M1943 (aka 7.62 x 39 mm, 7.62-mm Kalashnikov, and 7.62-mm obr 43g)
    }
}
