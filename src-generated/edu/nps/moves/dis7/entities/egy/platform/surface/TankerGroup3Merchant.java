package edu.nps.moves.dis7.entities.egy.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@5c671d7f
 * Country: Egypt (EGY)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24606
 */
public class TankerGroup3Merchant extends EntityType
{
    public TankerGroup3Merchant()
    {
        setCountry(Country.EGYPT_EGY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24606, Tanker (Group 3 Merchant)
    }
}
