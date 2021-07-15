package edu.nps.moves.dis7.entities.arg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5d6f64b1;
 * Country: Argentina (ARG);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31254
 */
public class D11LaArgentina extends EntityType
{
    /** Default constructor */
    public D11LaArgentina()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 18755, Guided Missile Destroyer
        setSubCategory((byte)1); // uid 18756, Almirante Brown Class (Meko 360H2)
        setSpecific((byte)2); // uid 31254, D 11 La Argentina
    }
}
