package edu.nps.moves.dis7.entities.irn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2e554a3b
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18170
 */
public class SSAConventionalAuxiliary extends EntityType
{
    public SSAConventionalAuxiliary()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)7); // uid 18170, SSA (Conventional Auxiliary)
    }
}
