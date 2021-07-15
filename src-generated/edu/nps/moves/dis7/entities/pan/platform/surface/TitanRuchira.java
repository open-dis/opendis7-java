package edu.nps.moves.dis7.entities.pan.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@73d6d0c;
 * Country: Panama (PAN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24569
 */
public class TitanRuchira extends EntityType
{
    /** Default constructor */
    public TitanRuchira()
    {
        setCountry(Country.PANAMA_PAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24556, Tanker (Group 3 Merchant)
        setSubCategory((byte)1); // uid 24568, Liquid Petroleum Gas (LPG)Tanker
        setSpecific((byte)1); // uid 24569, Titan Ruchira
    }
}
