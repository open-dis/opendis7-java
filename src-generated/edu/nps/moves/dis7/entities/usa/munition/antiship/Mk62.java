package edu.nps.moves.dis7.entities.usa.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5eeee124
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 19766
 */
public class Mk62 extends EntityType
{
    public Mk62()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)3); // uid 19748, Fixed
        setSubCategory((byte)8); // uid 19765, Quickstrike mines
        setSpecific((byte)1); // uid 19766, Mk 62
    }
}
