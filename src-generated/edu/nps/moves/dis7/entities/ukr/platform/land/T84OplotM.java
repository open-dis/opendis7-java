package edu.nps.moves.dis7.entities.ukr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2370ac7a;
 * Country: Ukraine (UKR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29843
 */
public class T84OplotM extends EntityType
{
    /** Default constructor */
    public T84OplotM()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 29838, Tank
        setSubCategory((byte)1); // uid 29839, T-84 MBT
        setSpecific((byte)4); // uid 29843, T-84 Oplot-M
    }
}
