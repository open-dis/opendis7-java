package edu.nps.moves.dis7.entities.nor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@22db8f4
 * Country: Norway (NOR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 18955
 */
public class PenguinMk2launcher extends EntityType
{
    public PenguinMk2launcher()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 18954, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 18955, Penguin Mk 2 launcher
    }
}
