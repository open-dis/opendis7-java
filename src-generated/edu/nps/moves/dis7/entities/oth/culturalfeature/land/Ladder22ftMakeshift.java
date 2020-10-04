package edu.nps.moves.dis7.entities.oth.culturalfeature.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@4f3fec43
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: LAND
 *
 * Entity type uid: 28483
 */
public class Ladder22ftMakeshift extends EntityType
{
    public Ladder22ftMakeshift()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)25); // uid 26509, Tools
        setSubCategory((byte)3); // uid 26512, Garden
        setSpecific((byte)1); // uid 28482, Ladder
        setExtra((byte)1); // uid 28483, Ladder, 22ft, Makeshift
    }
}
