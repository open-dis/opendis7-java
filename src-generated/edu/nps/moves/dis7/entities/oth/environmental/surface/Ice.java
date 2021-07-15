package edu.nps.moves.dis7.entities.oth.environmental.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@4070ace9;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: SURFACE;
 *
 * Entity type uid: 21925
 */
public class Ice extends EntityType
{
    /** Default constructor */
    public Ice()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)3); // uid 21925, Ice
    }
}
