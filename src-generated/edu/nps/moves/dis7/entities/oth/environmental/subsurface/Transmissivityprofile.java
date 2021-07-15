package edu.nps.moves.dis7.entities.oth.environmental.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@213835b6;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 21936
 */
public class Transmissivityprofile extends EntityType
{
    /** Default constructor */
    public Transmissivityprofile()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 21936, Transmissivity profile
    }
}
