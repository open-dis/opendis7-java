package edu.nps.moves.dis7.entities.syr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2aff9dff
 * Country: Syrian Arab Republic (SYR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31702
 */
public class SelfPropelledArtillery extends EntityType
{
    public SelfPropelledArtillery()
    {
        setCountry(Country.SYRIAN_ARAB_REPUBLIC_SYR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 31702, Self-Propelled Artillery
    }
}
