package edu.nps.moves.dis7.entities.deu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2fba3fc4
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 31331
 */
public class NH90SeaLion extends EntityType
{
    public NH90SeaLion()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)22); // uid 16379, Anti-Submarine Warfare / Patrol Helicopter
        setSubCategory((byte)2); // uid 16381, NFH 90
        setSpecific((byte)1); // uid 31331, NH90 Sea Lion
    }
}
