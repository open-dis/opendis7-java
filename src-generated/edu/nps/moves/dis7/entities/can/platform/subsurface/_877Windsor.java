package edu.nps.moves.dis7.entities.can.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4d50efb8;
 * Country: Canada (CAN);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 23126
 */
public class _877Windsor extends EntityType
{
    /** Default constructor */
    public _877Windsor()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 23123, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 23124, Victoria (Upholder) class
        setSpecific((byte)2); // uid 23126, 877 Windsor
    }
}
