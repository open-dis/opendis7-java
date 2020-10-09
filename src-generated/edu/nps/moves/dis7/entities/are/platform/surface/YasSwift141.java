package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@27e7c77f
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28238
 */
public class YasSwift141 extends EntityType
{
    public YasSwift141()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)84); // uid 28235, Private Motorboat
        setSubCategory((byte)4); // uid 28236, Very Large Motorboat (greater than 65ft/19.8m)
        setSpecific((byte)1); // uid 28237, Swift Class Superyacht
        setExtra((byte)1); // uid 28238, Yas / Swift141
    }
}
