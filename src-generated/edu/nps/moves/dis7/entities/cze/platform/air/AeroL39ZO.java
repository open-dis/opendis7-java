package edu.nps.moves.dis7.entities.cze.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4218d6a3
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30089
 */
public class AeroL39ZO extends EntityType
{
    public AeroL39ZO()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 30087, Attack/Strike
        setSubCategory((byte)1); // uid 30088, Aero L-39Z Albatros
        setSpecific((byte)1); // uid 30089, Aero L-39ZO
    }
}
