package edu.nps.moves.dis7.entities.gbr.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@100d0218
 * Country: United Kingdom of Great Britain and Northern Ireland (GBR)
 * Entity kind: Munition
 * Domain: ANTI_SUBMARINE
 *
 * Entity type uid: 21007
 */
public class StingRaytorpedo extends EntityType
{
    public StingRaytorpedo()
    {
        setCountry(Country.UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND_GBR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)1); // uid 21004, Guided
        setSubCategory((byte)3); // uid 21007, Sting Ray torpedo
    }
}
