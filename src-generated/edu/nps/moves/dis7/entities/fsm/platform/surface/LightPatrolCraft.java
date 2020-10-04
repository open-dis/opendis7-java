package edu.nps.moves.dis7.entities.fsm.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@27cf3151
 * Country: Micronesia (Federated States of) (FSM)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26711
 */
public class LightPatrolCraft extends EntityType
{
    public LightPatrolCraft()
    {
        setCountry(Country.MICRONESIA_FEDERATED_STATES_OF_FSM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26711, Light/Patrol Craft
    }
}
