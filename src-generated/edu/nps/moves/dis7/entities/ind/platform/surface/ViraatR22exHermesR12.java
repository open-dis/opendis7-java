package edu.nps.moves.dis7.entities.ind.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7ac0e420;
 * Country: India (IND);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26555
 */
public class ViraatR22exHermesR12 extends EntityType
{
    /** Default constructor */
    public ViraatR22exHermesR12()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)12); // uid 26553, Light Carrier
        setSubCategory((byte)1); // uid 26554, Viraat Class (ex-Centaur Class)
        setSpecific((byte)1); // uid 26555, Viraat R22 (ex-Hermes R12)
    }
}
