package edu.nps.moves.dis7.entities.grc.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@49ff7d8c;
 * Country: Greece (GRC);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 23388
 */
public class M63Kallisto extends EntityType
{
    /** Default constructor */
    public M63Kallisto()
    {
        setCountry(Country.GREECE_GRC);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 23385, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 23386, Evropi (Hunt) class
        setSpecific((byte)2); // uid 23388, M63 Kallisto
    }
}
