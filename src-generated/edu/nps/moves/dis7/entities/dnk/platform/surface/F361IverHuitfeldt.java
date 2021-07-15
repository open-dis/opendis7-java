package edu.nps.moves.dis7.entities.dnk.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4562e04d;
 * Country: Denmark (DNK);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 25432
 */
public class F361IverHuitfeldt extends EntityType
{
    /** Default constructor */
    public F361IverHuitfeldt()
    {
        setCountry(Country.ACTION_RESPONSE_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 25430, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 25431, Iver Huitfeldt Class
        setSpecific((byte)1); // uid 25432, F361 Iver Huitfeldt
    }
}
