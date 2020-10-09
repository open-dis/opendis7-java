package edu.nps.moves.dis7.entities.ser.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1a2909ae
 * Country: Serbia and Montenegro
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23675
 */
public class M55A3B13x20mm extends EntityType
{
    public M55A3B13x20mm()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 23670, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 23674, Towed VSHORAD Gun / Missile System
        setSpecific((byte)1); // uid 23675, M55A3B1 3 x 20-mm
    }
}
