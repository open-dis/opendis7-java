package edu.nps.moves.dis7.entities.arg.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7d6f77cc
 * Country: Argentina (ARG)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 32598
 */
public class S41SantaCruz extends EntityType
{
    public S41SantaCruz()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18761, SS (Conventional Attack - Torpedo, Patrol
        setSubCategory((byte)1); // uid 18762, Santa Cruz (TR 1700) Class (SS)
        setSpecific((byte)1); // uid 32598, S41 Santa Cruz
    }
}
