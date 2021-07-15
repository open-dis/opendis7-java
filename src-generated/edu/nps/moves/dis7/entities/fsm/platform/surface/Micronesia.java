package edu.nps.moves.dis7.entities.fsm.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@780ec4a5;
 * Country: Micronesia (Federated States of) (FSM);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26714
 */
public class Micronesia extends EntityType
{
    /** Default constructor */
    public Micronesia()
    {
        setCountry(Country.MICRONESIA_FEDERATED_STATES_OF_FSM);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26711, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26712, Pacific Class Patrol Boat
        setSpecific((byte)2); // uid 26714, Micronesia
    }
}
