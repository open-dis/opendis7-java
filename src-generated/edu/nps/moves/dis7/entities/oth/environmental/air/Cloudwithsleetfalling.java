package edu.nps.moves.dis7.entities.oth.environmental.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1bfa3893;
 * Country: Other;
 * Entity kind: Environmental;
 * Domain: AIR;
 *
 * Entity type uid: 21920
 */
public class Cloudwithsleetfalling extends EntityType
{
    /** Default constructor */
    public Cloudwithsleetfalling()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.ENVIRONMENTAL);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 21920, Cloud with sleet falling
    }
}
