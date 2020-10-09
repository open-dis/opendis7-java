package edu.nps.moves.dis7.entities.mhl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@37cd92d6
 * Country: Marshall Islands (MHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28170
 */
public class ANLWarringa extends EntityType
{
    public ANLWarringa()
    {
        setCountry(Country.MARSHALL_ISLANDS_MHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 28168, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 28169, Container Ship
        setSpecific((byte)1); // uid 28170, ANL Warringa
    }
}
