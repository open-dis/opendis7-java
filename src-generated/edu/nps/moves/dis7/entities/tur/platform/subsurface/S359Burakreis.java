package edu.nps.moves.dis7.entities.tur.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7f5538a1
 * Country: Turkey (TUR)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 23208
 */
public class S359Burakreis extends EntityType
{
    public S359Burakreis()
    {
        setCountry(Country.TURKEY_TUR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 19067, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)2); // uid 23201, Preveze class
        setSpecific((byte)7); // uid 23208, S359 Burakreis
    }
}
