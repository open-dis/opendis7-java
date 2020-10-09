package edu.nps.moves.dis7.entities.can.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4f063c0a
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 28703
 */
public class CT156HarvardII extends EntityType
{
    public CT156HarvardII()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28527, Trainer
        setSubCategory((byte)2); // uid 28702, Raytheon / Pilatus PC-9 Mk II (Beech Mk II)
        setSpecific((byte)1); // uid 28703, CT-156 Harvard II
    }
}
