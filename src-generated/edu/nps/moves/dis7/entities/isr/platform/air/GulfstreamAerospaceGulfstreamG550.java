package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@435fb7b5
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29164
 */
public class GulfstreamAerospaceGulfstreamG550 extends EntityType
{
    public GulfstreamAerospaceGulfstreamG550()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 18191, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)5); // uid 29164, Gulfstream Aerospace - Gulfstream G550
    }
}
