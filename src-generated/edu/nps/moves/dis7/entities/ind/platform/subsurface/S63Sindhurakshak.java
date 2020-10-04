package edu.nps.moves.dis7.entities.ind.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@130dca52
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 23199
 */
public class S63Sindhurakshak extends EntityType
{
    public S63Sindhurakshak()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 23189, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 23190, Sindhughosh (Kilo) Class
        setSpecific((byte)9); // uid 23199, S 63 Sindhurakshak
    }
}
