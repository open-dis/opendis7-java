package edu.nps.moves.dis7.entities.aus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6615435c
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 17615
 */
public class S76Dechaineux extends EntityType
{
    public S76Dechaineux()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)4); // uid 17609, SSG (Conventional Guided Missile)
        setSubCategory((byte)1); // uid 17611, Collins Class
        setSpecific((byte)4); // uid 17615, S 76 Dechaineux
    }
}
