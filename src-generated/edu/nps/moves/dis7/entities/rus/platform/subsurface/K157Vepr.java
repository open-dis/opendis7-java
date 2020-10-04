package edu.nps.moves.dis7.entities.rus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3d5790ea
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 27213
 */
public class K157Vepr extends EntityType
{
    public K157Vepr()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)3); // uid 14779, SSN (Nuclear Attack-Torpedo)
        setSubCategory((byte)9); // uid 14796, Akula II Class
        setSpecific((byte)1); // uid 27213, K-157 Vepr
    }
}
