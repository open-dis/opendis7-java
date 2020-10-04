package edu.nps.moves.dis7.entities.jpn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@625e134e
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 26999
 */
public class AsashioSS589TSS3601 extends EntityType
{
    public AsashioSS589TSS3601()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18910, SS (Conventional Attack-Torpedo Patrol)
        setSubCategory((byte)1); // uid 18911, Harushio Class (SS)
        setSpecific((byte)7); // uid 26999, Asashio SS-589/TSS-3601
    }
}
