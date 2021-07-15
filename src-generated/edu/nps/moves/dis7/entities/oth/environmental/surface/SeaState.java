package edu.nps.moves.dis7.entities.oth.environmental.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@3d6778d5;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: SURFACE;
 *
 * Entity type uid: 21923
 */
public class SeaState extends EntityType
{
    /** Default constructor */
    public SeaState()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)1); // uid 21923, Sea State
    }
}
