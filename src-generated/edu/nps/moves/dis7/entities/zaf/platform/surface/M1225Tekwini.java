package edu.nps.moves.dis7.entities.zaf.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@10c07b8d
 * Country: South Africa (ZAF)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27563
 */
public class M1225Tekwini extends EntityType
{
    public M1225Tekwini()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27559, Mine Countermeasure Ship/Craft
        setSubCategory((byte)2); // uid 27562, Lindau Class (Type 320)
        setSpecific((byte)1); // uid 27563, M1225 Tekwini
    }
}
