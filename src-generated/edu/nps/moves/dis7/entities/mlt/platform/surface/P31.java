package edu.nps.moves.dis7.entities.mlt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3670f00
 * Country: Malta (MLT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27575
 */
public class P31 extends EntityType
{
    public P31()
    {
        setCountry(Country.MALTA_MLT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27571, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27572, Kondor I Class
        setSpecific((byte)3); // uid 27575, P31
    }
}
