package edu.nps.moves.dis7.entities.ltu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7a138fc5;
 * Country: Lithuania (LTU);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 25618
 */
public class GulfstreamAerospaceGulfstreamIV extends EntityType
{
    /** Default constructor */
    public GulfstreamAerospaceGulfstreamIV()
    {
        setCountry(Country.LITHUANIA_LTU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 25617, Cargo/Tanker
        setSubCategory((byte)1); // uid 25618, Gulfstream Aerospace Gulfstream IV
    }
}
