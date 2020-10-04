package edu.nps.moves.dis7.entities.deu.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@673be18f
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 16779
 */
public class S188U9 extends EntityType
{
    public S188U9()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 16757, SS (Conventional attack-torpedo patrol)
        setSubCategory((byte)3); // uid 16778, Type 205
        setSpecific((byte)1); // uid 16779, S 188 U 9
    }
}
