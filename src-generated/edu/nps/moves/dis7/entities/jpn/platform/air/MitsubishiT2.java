package edu.nps.moves.dis7.entities.jpn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@132ddbab
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29184
 */
public class MitsubishiT2 extends EntityType
{
    public MitsubishiT2()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 24779, Trainer
        setSubCategory((byte)3); // uid 29184, Mitsubishi T-2
    }
}
