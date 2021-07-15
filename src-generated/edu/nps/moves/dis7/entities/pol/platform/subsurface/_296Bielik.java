package edu.nps.moves.dis7.entities.pol.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1286528d;
 * Country: Poland (POL);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 23043
 */
public class _296Bielik extends EntityType
{
    /** Default constructor */
    public _296Bielik()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 23037, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)2); // uid 23040, Sokol Class
        setSpecific((byte)3); // uid 23043, 296 Bielik
    }
}
