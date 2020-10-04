package edu.nps.moves.dis7.entities.srb.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3b1ed14b
 * Country: Serbia (SRB)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30157
 */
public class M94OganjC extends EntityType
{
    public M94OganjC()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 30155, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 30156, M-77 Oganj
        setSpecific((byte)1); // uid 30157, M-94 Oganj C
    }
}
