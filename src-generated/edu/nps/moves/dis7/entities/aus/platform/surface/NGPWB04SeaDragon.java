package edu.nps.moves.dis7.entities.aus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@180bc464
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 29932
 */
public class NGPWB04SeaDragon extends EntityType
{
    public NGPWB04SeaDragon()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)18); // uid 29927, Utility
        setSubCategory((byte)1); // uid 29928, Steber 43 Naval General Purpose Workboats
        setSpecific((byte)4); // uid 29932, NGPWB 04 Sea Dragon
    }
}
