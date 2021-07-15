package edu.nps.moves.dis7.entities.per.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@377c68c6;
 * Country: Peru (PER);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31452
 */
public class _156Pisco extends EntityType
{
    /** Default constructor */
    public _156Pisco()
    {
        setCountry(Country.PERU_PER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)56); // uid 31450, Amphibious Transport Dock
        setSubCategory((byte)1); // uid 31451, Makassar Class Landing Platform Dock
        setSpecific((byte)1); // uid 31452, 156 Pisco
    }
}
