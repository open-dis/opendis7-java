package edu.nps.moves.dis7.entities.mar.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4b4dd216
 * Country: Morocco (MAR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27729
 */
public class ElAighClass extends EntityType
{
    public ElAighClass()
    {
        setCountry(Country.MOROCCO_MAR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27726, Auxiliary
        setSubCategory((byte)2); // uid 27729, El Aigh Class
    }
}
