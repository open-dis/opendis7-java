package edu.nps.moves.dis7.entities.ven.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3709748f
 * Country: Venezuela (Bolivarian Republic of) (VEN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27765
 */
public class F24GeneralSoublette extends EntityType
{
    public F24GeneralSoublette()
    {
        setCountry(Country.VENEZUELA_BOLIVARIAN_REPUBLIC_OF_VEN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27760, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 27761, Lupo Class
        setSpecific((byte)4); // uid 27765, F-24 General Soublette
    }
}
