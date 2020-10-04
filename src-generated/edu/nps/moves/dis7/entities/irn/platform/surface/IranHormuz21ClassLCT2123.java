package edu.nps.moves.dis7.entities.irn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1253e7cb
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18108
 */
public class IranHormuz21ClassLCT2123 extends EntityType
{
    public IranHormuz21ClassLCT2123()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 18104, Landing Craft
        setSubCategory((byte)3); // uid 18107, Iran Hormuz 21 Class (LCT)
        setSpecific((byte)1); // uid 18108, 21-23
    }
}
