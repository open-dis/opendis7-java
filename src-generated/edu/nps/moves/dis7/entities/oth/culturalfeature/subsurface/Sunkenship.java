package edu.nps.moves.dis7.entities.oth.culturalfeature.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@40a8a26f;
 * Country: Other;
 * Entity kind: Cultural feature;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 22163
 */
public class Sunkenship extends EntityType
{
    /** Default constructor */
    public Sunkenship()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)3); // uid 22163, Sunken ship
    }
}
