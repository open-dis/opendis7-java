package edu.nps.moves.dis7.entities.vnm.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@38e83838
 * Country: Viet Nam (VNM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28605
 */
public class HQ012LyThaiTo extends EntityType
{
    public HQ012LyThaiTo()
    {
        setCountry(Country.VIET_NAM_VNM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 28602, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 28603, Gepard 3.9 Class
        setSpecific((byte)2); // uid 28605, HQ-012 Ly Thai To
    }
}
