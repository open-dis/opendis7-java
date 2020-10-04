package edu.nps.moves.dis7.entities.can.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@23d2a7e8
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30948
 */
public class MCharlesMB838229 extends EntityType
{
    public MCharlesMB838229()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)62); // uid 26269, Coast Guard Cutters
        setSubCategory((byte)8); // uid 30938, Midshore Patrol Vessel
        setSpecific((byte)11); // uid 30948, M. Charles M.B. (838229)
    }
}
