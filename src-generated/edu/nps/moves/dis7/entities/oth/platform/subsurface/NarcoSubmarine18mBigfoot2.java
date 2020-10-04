package edu.nps.moves.dis7.entities.oth.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1500e009
 * Country: Other
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 29697
 */
public class NarcoSubmarine18mBigfoot2 extends EntityType
{
    public NarcoSubmarine18mBigfoot2()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)82); // uid 29695, Semi-Submersible Boats
        setSubCategory((byte)1); // uid 29696, Generic Narco-Submarine
        setSpecific((byte)1); // uid 29697, Narco-Submarine, 18m, Bigfoot-2
    }
}
