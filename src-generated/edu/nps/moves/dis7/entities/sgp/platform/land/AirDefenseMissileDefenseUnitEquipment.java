package edu.nps.moves.dis7.entities.sgp.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2b10ace9
 * Country: Singapore (SGP)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 28710
 */
public class AirDefenseMissileDefenseUnitEquipment extends EntityType
{
    public AirDefenseMissileDefenseUnitEquipment()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 28710, Air Defense / Missile Defense Unit Equipment
    }
}
