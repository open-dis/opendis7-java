package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@56aaaecd;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 18198
 */
public class BellHelicopterTextronCanadaLtdTwinTwoTwelve extends EntityType
{
    /** Default constructor */
    public BellHelicopterTextronCanadaLtdTwinTwoTwelve()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 18195, Utility Helicopter
        setSubCategory((byte)3); // uid 18198, Bell Helicopter Textron Canada Ltd. Twin Two Twelve
    }
}
