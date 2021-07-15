package edu.nps.moves.dis7.entities.irq.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@5c08c46a;
 * Country: Iraq (IRQ);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 17999
 */
public class SurveillanceC2AirborneEarlyWarning extends EntityType
{
    /** Default constructor */
    public SurveillanceC2AirborneEarlyWarning()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 17999, Surveillance/C2 (Airborne Early Warning)
    }
}
