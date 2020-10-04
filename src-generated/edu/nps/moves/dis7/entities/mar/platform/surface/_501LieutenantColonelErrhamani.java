package edu.nps.moves.dis7.entities.mar.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4628b1d3
 * Country: Morocco (MAR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27696
 */
public class _501LieutenantColonelErrhamani extends EntityType
{
    public _501LieutenantColonelErrhamani()
    {
        setCountry(Country.MOROCCO_MAR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27691, Guided Missile Frigate (FFG)
        setSubCategory((byte)2); // uid 27695, Modified Descubierta Class
        setSpecific((byte)1); // uid 27696, 501 Lieutenant-Colonel Errhamani
    }
}
