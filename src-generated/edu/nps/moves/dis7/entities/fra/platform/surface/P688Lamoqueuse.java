package edu.nps.moves.dis7.entities.fra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@742ff096
 * Country: France (FRA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 15970
 */
public class P688Lamoqueuse extends EntityType
{
    public P688Lamoqueuse()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 15962, Light/patrol craft
        setSubCategory((byte)1); // uid 15963, P 400 class (fast attack craft--patrol)
        setSpecific((byte)7); // uid 15970, P 688 La moqueuse
    }
}
