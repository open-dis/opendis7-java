package edu.nps.moves.dis7.entities.twn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@d5d5353
 * Country: Taiwan, Province of China (TWN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 19240
 */
public class _791HaiShih extends EntityType
{
    public _791HaiShih()
    {
        setCountry(Country.TAIWAN_PROVINCE_OF_CHINA_TWN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 19238, SS (Conventional Attack-Torpedo Patrol)
        setSubCategory((byte)1); // uid 19239, Hai Shih (ex. Guppy II)
        setSpecific((byte)1); // uid 19240, 791 Hai Shih
    }
}
