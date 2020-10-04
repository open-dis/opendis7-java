package edu.nps.moves.dis7.entities.mmr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4d411036
 * Country: Myanmar (MMR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26768
 */
public class F21MaharBandoola extends EntityType
{
    public F21MaharBandoola()
    {
        setCountry(Country.MYANMAR_MMR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 26766, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 26767, Jianghu-II Class (Type 053H1)
        setSpecific((byte)1); // uid 26768, F21 Mahar Bandoola
    }
}
