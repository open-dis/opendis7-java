package edu.nps.moves.dis7.entities.ukr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@64d4f7c7;
 * Country: Ukraine (UKR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 29871
 */
public class U311Cherkasy extends EntityType
{
    /** Default constructor */
    public U311Cherkasy()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29868, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 29869, Natya I Class
        setSpecific((byte)2); // uid 29871, U311 Cherkasy
    }
}
