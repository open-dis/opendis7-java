package edu.nps.moves.dis7.entities.est.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@10aa41f2
 * Country: Estonia (EST)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27775
 */
public class M315Ugandi extends EntityType
{
    public M315Ugandi()
    {
        setCountry(Country.ESTONIA_EST);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27555, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27772, Sandown Class
        setSpecific((byte)3); // uid 27775, M315 Ugandi
    }
}
