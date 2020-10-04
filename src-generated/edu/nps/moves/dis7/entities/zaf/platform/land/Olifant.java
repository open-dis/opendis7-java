package edu.nps.moves.dis7.entities.zaf.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5d7ca698
 * Country: South Africa (ZAF)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 19091
 */
public class Olifant extends EntityType
{
    public Olifant()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 19090, Tank
        setSubCategory((byte)1); // uid 19091, Olifant
    }
}
