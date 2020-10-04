package edu.nps.moves.dis7.entities.fra.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@39652a30
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32471
 */
public class M51Stage2Booster extends EntityType
{
    public M51Stage2Booster()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21195, Guided
        setSubCategory((byte)6); // uid 29002, M51 SLBM
        setSpecific((byte)5); // uid 32471, M51 Stage 2 Booster
    }
}
