package edu.nps.moves.dis7.entities.rus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@7c8f9c2e
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 14808
 */
public class SSANNuclearAuxiliary extends EntityType
{
    public SSANNuclearAuxiliary()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)6); // uid 14808, SSAN (Nuclear Auxiliary)
    }
}
