package edu.nps.moves.dis7.entities.bhs.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7ca48474
 * Country: Bahamas (BHS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24486
 */
public class TankerGroup3Merchant extends EntityType
{
    public TankerGroup3Merchant()
    {
        setCountry(Country.BAHAMAS_BHS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24486, Tanker (Group 3 Merchant)
    }
}
