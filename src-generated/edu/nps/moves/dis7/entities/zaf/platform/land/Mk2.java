package edu.nps.moves.dis7.entities.zaf.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1f77b5cc
 * Country: South Africa (ZAF)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 19093
 */
public class Mk2 extends EntityType
{
    public Mk2()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 19090, Tank
        setSubCategory((byte)1); // uid 19091, Olifant
        setSpecific((byte)2); // uid 19093, Mk 2
    }
}
