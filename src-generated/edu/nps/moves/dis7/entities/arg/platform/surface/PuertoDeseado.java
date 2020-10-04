package edu.nps.moves.dis7.entities.arg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1175e2db
 * Country: Argentina (ARG)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18759
 */
public class PuertoDeseado extends EntityType
{
    public PuertoDeseado()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 18757, Auxiliary
        setSubCategory((byte)2); // uid 18759, Puerto Deseado
    }
}
