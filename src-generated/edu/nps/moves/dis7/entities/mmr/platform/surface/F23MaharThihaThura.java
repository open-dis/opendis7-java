package edu.nps.moves.dis7.entities.mmr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7adbd080
 * Country: Myanmar (MMR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26769
 */
public class F23MaharThihaThura extends EntityType
{
    public F23MaharThihaThura()
    {
        setCountry(Country.MYANMAR_MMR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 26766, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 26767, Jianghu-II Class (Type 053H1)
        setSpecific((byte)2); // uid 26769, F23 Mahar Thiha Thura
    }
}
