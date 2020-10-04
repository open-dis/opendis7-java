package edu.nps.moves.dis7.entities.deu.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@58326051
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 16786
 */
public class Type2091200 extends EntityType
{
    public Type2091200()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 16757, SS (Conventional attack-torpedo patrol)
        setSubCategory((byte)4); // uid 16783, Type 209
        setSpecific((byte)2); // uid 16786, 1200
    }
}
