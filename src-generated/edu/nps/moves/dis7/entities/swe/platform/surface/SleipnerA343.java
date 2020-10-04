package edu.nps.moves.dis7.entities.swe.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@102ecc22
 * Country: Sweden (SWE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26866
 */
public class SleipnerA343 extends EntityType
{
    public SleipnerA343()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 26855, Auxiliary
        setSubCategory((byte)3); // uid 26865, Logistics/Transport Ships
        setSpecific((byte)1); // uid 26866, Sleipner (A343)
    }
}
