package edu.nps.moves.dis7.entities.ukr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@66b59b7d
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29840
 */
public class T84 extends EntityType
{
    public T84()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 29838, Tank
        setSubCategory((byte)1); // uid 29839, T-84 MBT
        setSpecific((byte)1); // uid 29840, T-84
    }
}
