package edu.nps.moves.dis7.entities.ven.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@f245bdd;
 * Country: Venezuela (Bolivarian Republic of) (VEN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27763
 */
public class F22AlmiranteBrion extends EntityType
{
    /** Default constructor */
    public F22AlmiranteBrion()
    {
        setCountry(Country.VENEZUELA_BOLIVARIAN_REPUBLIC_OF_VEN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27760, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 27761, Lupo Class
        setSpecific((byte)2); // uid 27763, F-22 Almirante Brion
    }
}
