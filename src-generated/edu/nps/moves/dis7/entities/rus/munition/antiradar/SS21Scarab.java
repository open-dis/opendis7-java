package edu.nps.moves.dis7.entities.rus.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@57b9389f
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: ANTI_RADAR
 *
 * Entity type uid: 20517
 */
public class SS21Scarab extends EntityType
{
    public SS21Scarab()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 20509, Guided
        setSubCategory((byte)6); // uid 20517, SS-21 Scarab
    }
}
