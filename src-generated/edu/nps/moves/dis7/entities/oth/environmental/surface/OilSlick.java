package edu.nps.moves.dis7.entities.oth.environmental.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@a84338a;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: SURFACE;
 *
 * Entity type uid: 21924
 */
public class OilSlick extends EntityType
{
    /** Default constructor */
    public OilSlick()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)2); // uid 21924, Oil Slick
    }
}
