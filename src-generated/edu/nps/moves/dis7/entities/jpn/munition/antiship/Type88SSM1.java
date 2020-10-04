package edu.nps.moves.dis7.entities.jpn.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@aa1bb14
 * Country: Japan (JPN)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 29035
 */
public class Type88SSM1 extends EntityType
{
    public Type88SSM1()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21690, Guided
        setSubCategory((byte)2); // uid 21692, SSM-1A/1B (type 88/90)
        setSpecific((byte)1); // uid 29035, Type 88 (SSM-1)
    }
}
