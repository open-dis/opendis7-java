package edu.nps.moves.dis7.entities.deu.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2c8b8de0
 * Country: Germany (DEU)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 21231
 */
public class MIFF extends EntityType
{
    public MIFF()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)3); // uid 21229, Fixed
        setSubCategory((byte)1); // uid 21230, Anti-Tank mine
        setSpecific((byte)1); // uid 21231, MIFF
    }
}
