package edu.nps.moves.dis7.entities.oth.environmental.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@45c423b3
 * Country: Other
 * Entity kind: Environmental
 * Domain: SURFACE
 *
 * Entity type uid: 21926
 */
public class Debris extends EntityType
{
    public Debris()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 21926, Debris
    }
}
