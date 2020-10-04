package edu.nps.moves.dis7.entities.srb.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1bc776b7
 * Country: Serbia (SRB)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30158
 */
public class LRSVMMorava extends EntityType
{
    public LRSVMMorava()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 30155, Self-Propelled Artillery
        setSubCategory((byte)2); // uid 30158, LRSVM Morava
    }
}
