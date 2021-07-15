package edu.nps.moves.dis7.entities.phl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@430fa4ef;
 * Country: Philippines (PHL);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31151
 */
public class _288WarayexL133Betano extends EntityType
{
    /** Default constructor */
    public _288WarayexL133Betano()
    {
        setCountry(Country.PHILIPPINES_PHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 31149, Landing Craft
        setSubCategory((byte)1); // uid 31150, Ivatan Class (ex Balikpapan Class)
        setSpecific((byte)1); // uid 31151, 288 Waray (ex L 133 Betano)
    }
}
