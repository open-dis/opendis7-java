package edu.nps.moves.dis7.entities.yem.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7f27f59b
 * Country: Yemen (YEM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18747
 */
public class _135tankerwater extends EntityType
{
    public _135tankerwater()
    {
        setCountry(Country.YEMEN_YEM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 18745, Auxiliary
        setSubCategory((byte)1); // uid 18746, Toplivo Class
        setSpecific((byte)1); // uid 18747, 135 (tanker-water)
    }
}
