package edu.nps.moves.dis7.entities.deu.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3f048c86
 * Country: Germany (DEU)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 28091
 */
public class DM2A1Seal extends EntityType
{
    public DM2A1Seal()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21234, Guided
        setSubCategory((byte)5); // uid 21239, DM2 Series Torpedoes
        setSpecific((byte)1); // uid 28091, DM2A1 Seal
    }
}
