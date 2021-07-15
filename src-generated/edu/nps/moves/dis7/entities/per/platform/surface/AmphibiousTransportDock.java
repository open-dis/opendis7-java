package edu.nps.moves.dis7.entities.per.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@238ad8c;
 * Country: Peru (PER);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31450
 */
public class AmphibiousTransportDock extends EntityType
{
    /** Default constructor */
    public AmphibiousTransportDock()
    {
        setCountry(Country.PERU_PER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)56); // uid 31450, Amphibious Transport Dock
    }
}
