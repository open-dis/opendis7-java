package edu.nps.moves.dis7.entities.can.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2fd4312a
 * Country: Canada (CAN)
 * Entity kind: Expendable
 * Domain: AIR
 *
 * Entity type uid: 31838
 */
public class WDIGreenSARNightBallLight extends EntityType
{
    public WDIGreenSARNightBallLight()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)13); // uid 31834, SAR Night Light (SRNL)
        setSubCategory((byte)1); // uid 31835, LED SRNL
        setSpecific((byte)3); // uid 31838, WDI Green SAR Night Ball Light
    }
}
