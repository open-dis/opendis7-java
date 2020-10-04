package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2fb69ff6
 * Country: Other
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 31034
 */
public class GenericUAVIED extends EntityType
{
    public GenericUAVIED()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)50); // uid 31031, Unmanned
        setSubCategory((byte)1); // uid 31032, Generic UAV
        setSpecific((byte)2); // uid 31034, Generic UAV - IED
    }
}
