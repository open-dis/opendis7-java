package edu.nps.moves.dis7.entities.usa.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1e6cb932;
 * Country: United States of America (USA);
 * Entity kind: Expendable;
 * Domain: AIR;
 *
 * Entity type uid: 22254
 */
public class ANALE55FiberOpticTowedDecoyFOTD extends EntityType
{
    /** Default constructor */
    public ANALE55FiberOpticTowedDecoyFOTD()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 22251, Active emitter
        setSubCategory((byte)1); // uid 22252, Towed Decoy
        setSpecific((byte)2); // uid 22254, AN/ALE-55 Fiber Optic Towed Decoy (FOTD)
    }
}
