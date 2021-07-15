package edu.nps.moves.dis7.entities.oth.environmental.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@75cacb3e;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 21931
 */
public class SoundVelocityProfile extends EntityType
{
    /** Default constructor */
    public SoundVelocityProfile()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)1); // uid 21931, Sound Velocity Profile
    }
}
