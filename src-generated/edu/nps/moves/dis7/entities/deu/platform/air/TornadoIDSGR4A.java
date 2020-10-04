package edu.nps.moves.dis7.entities.deu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6f1c29b7
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 26597
 */
public class TornadoIDSGR4A extends EntityType
{
    public TornadoIDSGR4A()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 16333, Attack/Strike
        setSubCategory((byte)2); // uid 16340, Panavia Tornado Interdiction/Strike (IDS)
        setSpecific((byte)4); // uid 26597, Tornado IDS GR4A
    }
}
