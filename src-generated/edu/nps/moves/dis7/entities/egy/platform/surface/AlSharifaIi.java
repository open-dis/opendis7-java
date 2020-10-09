package edu.nps.moves.dis7.entities.egy.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@445b295b
 * Country: Egypt (EGY)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24608
 */
public class AlSharifaIi extends EntityType
{
    public AlSharifaIi()
    {
        setCountry(Country.EGYPT_EGY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24606, Tanker (Group 3 Merchant)
        setSubCategory((byte)1); // uid 24607, Liquid Petroleum Gas (LPG)Tanker
        setSpecific((byte)1); // uid 24608, Al Sharifa Ii
    }
}
