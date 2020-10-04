package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@47c4ecdc
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 31781
 */
public class BirdEye100 extends EntityType
{
    public BirdEye100()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)50); // uid 23487, Unmanned
        setSubCategory((byte)8); // uid 31780, IAI Bird Eye UAV Family
        setSpecific((byte)1); // uid 31781, Bird Eye 100
    }
}
