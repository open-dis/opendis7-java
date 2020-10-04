package edu.nps.moves.dis7.entities.phl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@42cc13a0
 * Country: Philippines (PHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 33023
 */
public class AmphibiousTransportDock extends EntityType
{
    public AmphibiousTransportDock()
    {
        setCountry(Country.PHILIPPINES_PHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)56); // uid 33023, Amphibious Transport Dock
    }
}
