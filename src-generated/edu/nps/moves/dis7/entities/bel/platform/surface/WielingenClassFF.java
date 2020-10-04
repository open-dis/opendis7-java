package edu.nps.moves.dis7.entities.bel.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@28feb3fa
 * Country: Belgium (BEL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18765
 */
public class WielingenClassFF extends EntityType
{
    public WielingenClassFF()
    {
        setCountry(Country.BELGIUM_BEL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 18764, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 18765, Wielingen Class (FF)
    }
}
