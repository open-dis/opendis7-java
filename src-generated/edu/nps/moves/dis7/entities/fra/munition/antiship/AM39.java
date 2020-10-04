package edu.nps.moves.dis7.entities.fra.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2cccf134
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 21091
 */
public class AM39 extends EntityType
{
    public AM39()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21088, Guided
        setSubCategory((byte)1); // uid 21089, Exocet
        setSpecific((byte)2); // uid 21091, AM-39
    }
}
