package edu.nps.moves.dis7.entities.cze.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4c583ecf
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30075
 */
public class T72M4CZ extends EntityType
{
    public T72M4CZ()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 30074, Tank
        setSubCategory((byte)1); // uid 30075, T-72M4CZ
    }
}
