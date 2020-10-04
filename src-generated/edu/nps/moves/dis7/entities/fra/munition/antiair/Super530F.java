package edu.nps.moves.dis7.entities.fra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5bb8e6fc
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 21045
 */
public class Super530F extends EntityType
{
    public Super530F()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21028, Guided
        setSubCategory((byte)10); // uid 21044, Super 530
        setSpecific((byte)1); // uid 21045, Super 530F
    }
}
