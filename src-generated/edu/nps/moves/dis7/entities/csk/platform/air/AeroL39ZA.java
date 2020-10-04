package edu.nps.moves.dis7.entities.csk.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5fe94a96
 * Country: Czechoslovakia (CSK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19124
 */
public class AeroL39ZA extends EntityType
{
    public AeroL39ZA()
    {
        setCountry(Country.CZECHOSLOVAKIA_CSK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 19121, Attack / Strike
        setSubCategory((byte)1); // uid 19122, Aero L-39Z Albatros
        setSpecific((byte)2); // uid 19124, Aero L-39ZA
    }
}
