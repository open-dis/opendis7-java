package edu.nps.moves.dis7.entities.aut.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2d6e8792;
 * Country: Austria (AUT);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31908
 */
public class SK105A2S extends EntityType
{
    /** Default constructor */
    public SK105A2S()
    {
        setCountry(Country.AUSTRIA_AUT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 31906, Tank
        setSubCategory((byte)1); // uid 31907, SK-105 Kurassier
        setSpecific((byte)1); // uid 31908, SK-105 A2S
    }
}
