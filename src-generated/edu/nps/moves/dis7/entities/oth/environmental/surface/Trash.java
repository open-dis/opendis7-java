package edu.nps.moves.dis7.entities.oth.environmental.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@702096ef
 * Country: Other
 * Entity kind: Environmental
 * Domain: SURFACE
 *
 * Entity type uid: 25216
 */
public class Trash extends EntityType
{
    public Trash()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)9); // uid 25216, Trash
    }
}
