package edu.nps.moves.dis7.entities.cze.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@47eaca72
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30079
 */
public class SelfPropelledArtillery extends EntityType
{
    public SelfPropelledArtillery()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 30079, Self-Propelled Artillery
    }
}
