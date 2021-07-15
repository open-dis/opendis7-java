package edu.nps.moves.dis7.entities.mys.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6e57e95e;
 * Country: Malaysia (MYS);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28455
 */
public class F173Perak extends EntityType
{
    /** Default constructor */
    public F173Perak()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27457, Frigate (including Corvette)
        setSubCategory((byte)2); // uid 28452, Kedah Class
        setSpecific((byte)3); // uid 28455, F173 Perak
    }
}
