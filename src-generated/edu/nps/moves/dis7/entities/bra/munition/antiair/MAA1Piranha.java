package edu.nps.moves.dis7.entities.bra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5a05dd30;
 * Country: Brazil (BRA);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 28958
 */
public class MAA1Piranha extends EntityType
{
    /** Default constructor */
    public MAA1Piranha()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 28957, Guided
        setSubCategory((byte)1); // uid 28958, MAA-1 Piranha
    }
}
