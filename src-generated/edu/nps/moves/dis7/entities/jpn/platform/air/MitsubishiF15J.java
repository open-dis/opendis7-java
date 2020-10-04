package edu.nps.moves.dis7.entities.jpn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7383eae2
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29175
 */
public class MitsubishiF15J extends EntityType
{
    public MitsubishiF15J()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 24798, Fighter/Air Defense
        setSubCategory((byte)2); // uid 29175, Mitsubishi F-15J
    }
}
