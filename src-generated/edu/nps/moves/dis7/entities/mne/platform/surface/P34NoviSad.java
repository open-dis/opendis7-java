package edu.nps.moves.dis7.entities.mne.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5910de75
 * Country: Montenegro (MNE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30133
 */
public class P34NoviSad extends EntityType
{
    public P34NoviSad()
    {
        setCountry(Country.MONTENEGRO_MNE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 30130, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 30131, Kotor-Class Frigate
        setSpecific((byte)2); // uid 30133, P-34 Novi Sad
    }
}
