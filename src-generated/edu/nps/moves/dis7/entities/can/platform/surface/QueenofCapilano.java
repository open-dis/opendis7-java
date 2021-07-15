package edu.nps.moves.dis7.entities.can.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@69a3d1d;
 * Country: Canada (CAN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31622
 */
public class QueenofCapilano extends EntityType
{
    /** Default constructor */
    public QueenofCapilano()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)80); // uid 31620, Passenger Vessel (Group 1 Merchant)
        setSubCategory((byte)4); // uid 31621, Ferry
        setSpecific((byte)1); // uid 31622, Queen of Capilano
    }
}
