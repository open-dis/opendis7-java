package edu.nps.moves.dis7.entities.jpn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@18245eb0
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29176
 */
public class MitsubishiMcDonnellDouglasF4EJ extends EntityType
{
    public MitsubishiMcDonnellDouglasF4EJ()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 24798, Fighter/Air Defense
        setSubCategory((byte)3); // uid 29176, Mitsubishi / McDonnell Douglas F-4EJ
    }
}
