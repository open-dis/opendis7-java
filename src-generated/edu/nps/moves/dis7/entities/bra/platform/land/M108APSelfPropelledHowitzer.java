package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@59fa1d9b
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 32026
 */
public class M108APSelfPropelledHowitzer extends EntityType
{
    public M108APSelfPropelledHowitzer()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 24386, Self-Propelled Artillery
        setSubCategory((byte)2); // uid 32026, M108AP Self Propelled Howitzer
    }
}
