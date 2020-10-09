package edu.nps.moves.dis7.entities.ser.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@278667fd
 * Country: Serbia and Montenegro
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23672
 */
public class BOV3wM55A4B13x20mm extends EntityType
{
    public BOV3wM55A4B13x20mm()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 23670, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)1); // uid 23671, Self -Propelled VSHORAD Gun / Missile System
        setSpecific((byte)1); // uid 23672, BOV-3 w/ M55A4B1 3 x 20-mm
    }
}
