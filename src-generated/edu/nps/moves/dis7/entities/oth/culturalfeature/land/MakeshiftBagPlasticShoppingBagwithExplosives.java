package edu.nps.moves.dis7.entities.oth.culturalfeature.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@528e5e38
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: LAND
 *
 * Entity type uid: 26351
 */
public class MakeshiftBagPlasticShoppingBagwithExplosives extends EntityType
{
    public MakeshiftBagPlasticShoppingBagwithExplosives()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 21973, Obstacle
        setSubCategory((byte)34); // uid 26174, Makeshift Bag (Litter)
        setSpecific((byte)1); // uid 26351, Makeshift Bag, Plastic Shopping Bag with Explosives
    }
}
