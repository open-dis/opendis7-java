package edu.nps.moves.dis7.entities.bgr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5abca1e0
 * Country: Bulgaria (BGR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27891
 */
public class _701Sirius extends EntityType
{
    public _701Sirius()
    {
        setCountry(Country.BULGARIA_BGR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 27889, Tank Landing Ship
        setSubCategory((byte)1); // uid 27890, Polnochny Class
        setSpecific((byte)1); // uid 27891, 701 Sirius
    }
}
