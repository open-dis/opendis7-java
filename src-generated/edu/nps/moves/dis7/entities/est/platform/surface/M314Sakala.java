package edu.nps.moves.dis7.entities.est.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@c86b9e3
 * Country: Estonia (EST)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27774
 */
public class M314Sakala extends EntityType
{
    public M314Sakala()
    {
        setCountry(Country.ESTONIA_EST);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27555, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27772, Sandown Class
        setSpecific((byte)2); // uid 27774, M314 Sakala
    }
}
