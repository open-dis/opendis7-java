package edu.nps.moves.dis7.entities.swe.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5e1d03d7;
 * Country: Sweden (SWE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 32895
 */
public class _003Amfitrite extends EntityType
{
    /** Default constructor */
    public _003Amfitrite()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)62); // uid 26889, Coast Guard Cutters
        setSubCategory((byte)2); // uid 32892, KBV 001 Class
        setSpecific((byte)3); // uid 32895, 003 Amfitrite
    }
}
