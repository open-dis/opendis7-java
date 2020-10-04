package edu.nps.moves.dis7.entities.usa.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@74c7522c
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 19756
 */
public class Mk52Mod3 extends EntityType
{
    public Mk52Mod3()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)3); // uid 19748, Fixed
        setSubCategory((byte)5); // uid 19753, Mk 52 bottom mine
        setSpecific((byte)3); // uid 19756, Mk 52 Mod 3
    }
}
