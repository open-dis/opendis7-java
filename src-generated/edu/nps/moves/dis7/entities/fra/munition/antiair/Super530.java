package edu.nps.moves.dis7.entities.fra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@138f0661;
 * Country: France (FRA);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 21044
 */
public class Super530 extends EntityType
{
    /** Default constructor */
    public Super530()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21028, Guided
        setSubCategory((byte)10); // uid 21044, Super 530
    }
}