package edu.nps.moves.dis7.entities.idn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2d6764b2
 * Country: Indonesia (IDN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31068
 */
public class _826KelabangexKRIPulauRondo725 extends EntityType
{
    public _826KelabangexKRIPulauRondo725()
    {
        setCountry(Country.INDONESIA_IDN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 31038, Light/Patrol Craft
        setSubCategory((byte)3); // uid 31066, Kondor II Class (Patrol Duty Configuration)
        setSpecific((byte)2); // uid 31068, 826 Kelabang - (ex-KRI Pulau Rondo 725)
    }
}
