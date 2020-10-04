package edu.nps.moves.dis7.entities.pak.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3c4bc9fc
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30453
 */
public class SA316AAlouetteIII extends EntityType
{
    public SA316AAlouetteIII()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 30451, Utility Helicopter
        setSubCategory((byte)1); // uid 30452, Aerospatiale Alouette III
        setSpecific((byte)1); // uid 30453, SA 316A Alouette III
    }
}
