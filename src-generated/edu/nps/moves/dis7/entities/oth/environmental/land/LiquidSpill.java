package edu.nps.moves.dis7.entities.oth.environmental.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2d9de284;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: LAND;
 *
 * Entity type uid: 23899
 */
public class LiquidSpill extends EntityType
{
    /** Default constructor */
    public LiquidSpill()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 23899, Liquid Spill
    }
}
