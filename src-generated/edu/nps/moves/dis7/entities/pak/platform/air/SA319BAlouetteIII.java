package edu.nps.moves.dis7.entities.pak.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3569edd5
 * Country: Pakistan (PAK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30455
 */
public class SA319BAlouetteIII extends EntityType
{
    public SA319BAlouetteIII()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 30451, Utility Helicopter
        setSubCategory((byte)1); // uid 30452, Aerospatiale Alouette III
        setSpecific((byte)3); // uid 30455, SA 319B Alouette III
    }
}
