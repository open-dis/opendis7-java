package edu.nps.moves.dis7.entities.ukr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@75181b50
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27848
 */
public class U156Kremenchuk extends EntityType
{
    public U156Kremenchuk()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27845, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 27846, Tarantul II (Molnya) Class
        setSpecific((byte)2); // uid 27848, U-156 Kremenchuk
    }
}
