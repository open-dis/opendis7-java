package edu.nps.moves.dis7.entities.pol.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@452c8a40;
 * Country: Poland (POL);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24805
 */
public class PZLSwidnikW3Sokol extends EntityType
{
    /** Default constructor */
    public PZLSwidnikW3Sokol()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 24803, Utility Helicopter
        setSubCategory((byte)2); // uid 24805, PZL-Swidnik W-3 Sokol
    }
}
