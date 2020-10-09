package edu.nps.moves.dis7.entities.deu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1863d2fe
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29854
 */
public class SchleicherASK21 extends EntityType
{
    public SchleicherASK21()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)83); // uid 29852, Civilian Fixed Wing Aircraft, Glider
        setSubCategory((byte)1); // uid 29853, Sail Plane
        setSpecific((byte)1); // uid 29854, Schleicher ASK 21
    }
}
