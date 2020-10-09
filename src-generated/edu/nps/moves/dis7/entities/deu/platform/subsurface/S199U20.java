package edu.nps.moves.dis7.entities.deu.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1e461e41
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 16762
 */
public class S199U20 extends EntityType
{
    public S199U20()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 16757, SS (Conventional attack-torpedo patrol)
        setSubCategory((byte)1); // uid 16758, Type 206
        setSpecific((byte)4); // uid 16762, S 199 U 20
    }
}
