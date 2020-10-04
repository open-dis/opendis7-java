package edu.nps.moves.dis7.entities.phl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@138a7441
 * Country: Philippines (PHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28423
 */
public class PS36ApolinarioMabini extends EntityType
{
    public PS36ApolinarioMabini()
    {
        setCountry(Country.PHILIPPINES_PHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 28420, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 28421, Jacinto Class
        setSpecific((byte)2); // uid 28423, PS 36 Apolinario Mabini
    }
}
