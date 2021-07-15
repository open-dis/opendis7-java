package edu.nps.moves.dis7.entities.grc.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@41e68d87;
 * Country: Greece (GRC);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 23387
 */
public class M62Evropi extends EntityType
{
    /** Default constructor */
    public M62Evropi()
    {
        setCountry(Country.GREECE_GRC);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 23385, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 23386, Evropi (Hunt) class
        setSpecific((byte)1); // uid 23387, M62 Evropi
    }
}
