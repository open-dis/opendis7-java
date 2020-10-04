package edu.nps.moves.dis7.entities.bgr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@18eed359
 * Country: Bulgaria (BGR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 32904
 */
public class _11Smeli extends EntityType
{
    public _11Smeli()
    {
        setCountry(Country.BULGARIA_BGR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27868, Frigate (including Corvette)
        setSubCategory((byte)4); // uid 32903, Koni Class (Project 1159)
        setSpecific((byte)1); // uid 32904, 11 Smeli
    }
}
