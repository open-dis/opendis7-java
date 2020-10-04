package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@28d25987
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 32027
 */
public class M109A3SelfPropelledHowitzer extends EntityType
{
    public M109A3SelfPropelledHowitzer()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 24386, Self-Propelled Artillery
        setSubCategory((byte)3); // uid 32027, M109A3 Self Propelled Howitzer
    }
}
