package edu.nps.moves.dis7.entities.prt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7bc9e6ab
 * Country: Portugal (PRT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23092
 */
public class F330VascoDaGama extends EntityType
{
    public F330VascoDaGama()
    {
        setCountry(Country.PORTUGAL_PRT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 23090, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 23091, Vasco Da Gama (Meko 200) Class
        setSpecific((byte)1); // uid 23092, F330 Vasco Da Gama
    }
}
