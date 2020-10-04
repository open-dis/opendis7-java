package edu.nps.moves.dis7.entities.deu.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@255d9277
 * Country: Germany (DEU)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 28092
 */
public class DM2A3 extends EntityType
{
    public DM2A3()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21234, Guided
        setSubCategory((byte)5); // uid 21239, DM2 Series Torpedoes
        setSpecific((byte)2); // uid 28092, DM2A3
    }
}
