package edu.nps.moves.dis7.entities.pan.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@15515c51;
 * Country: Panama (PAN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31886
 */
public class ZumbidosPalmaresFerry extends EntityType
{
    /** Default constructor */
    public ZumbidosPalmaresFerry()
    {
        setCountry(Country.PANAMA_PAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)80); // uid 31884, Passenger Vessel (Group 1 Merchant)
        setSubCategory((byte)4); // uid 31885, Ferry
        setSpecific((byte)1); // uid 31886, Zumbi dos Palmares (Ferry)
    }
}
