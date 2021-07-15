package edu.nps.moves.dis7.entities.oth.environmental.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6d3163a6;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: LAND;
 *
 * Entity type uid: 21910
 */
public class Radarcollectednoise extends EntityType
{
    /** Default constructor */
    public Radarcollectednoise()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 21910, Radar collected noise
    }
}
