package edu.nps.moves.dis7.entities.oth.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6ea3a513
 * Country: Other
 * Entity kind: Expendable
 * Domain: SURFACE
 *
 * Entity type uid: 32653
 */
public class ELVAMarker extends EntityType
{
    public ELVAMarker()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)12); // uid 32652, Combined Flare and Smoke Generator
        setSubCategory((byte)1); // uid 32653, ELVA Marker
    }
}
