package edu.nps.moves.dis7.entities.jpn.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7faa0680
 * Country: Japan (JPN)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 29036
 */
public class Type90SSM1B extends EntityType
{
    public Type90SSM1B()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 21690, Guided
        setSubCategory((byte)2); // uid 21692, SSM-1A/1B (type 88/90)
        setSpecific((byte)2); // uid 29036, Type 90 (SSM-1B)
    }
}
