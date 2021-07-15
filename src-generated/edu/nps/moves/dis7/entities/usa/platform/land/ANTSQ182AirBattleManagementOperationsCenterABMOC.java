package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2e463f4;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22965
 */
public class ANTSQ182AirBattleManagementOperationsCenterABMOC extends EntityType
{
    /** Default constructor */
    public ANTSQ182AirBattleManagementOperationsCenterABMOC()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 10679, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)8); // uid 22964, ADA C2 Fixed Position
        setSpecific((byte)1); // uid 22965, AN/TSQ-182 Air Battle Management Operations Center (ABMOC)
    }
}
