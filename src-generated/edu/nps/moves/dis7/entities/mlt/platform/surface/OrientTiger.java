package edu.nps.moves.dis7.entities.mlt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@790174f2
 * Country: Malta (MLT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24492
 */
public class OrientTiger extends EntityType
{
    public OrientTiger()
    {
        setCountry(Country.MALTA_MLT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24490, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)2); // uid 24491, Dry Bulk Cargo Ship
        setSpecific((byte)1); // uid 24492, Orient Tiger
    }
}
