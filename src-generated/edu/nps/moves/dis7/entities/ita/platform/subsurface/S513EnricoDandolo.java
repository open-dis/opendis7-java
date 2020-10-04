package edu.nps.moves.dis7.entities.ita.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3ce3db41
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18662
 */
public class S513EnricoDandolo extends EntityType
{
    public S513EnricoDandolo()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18649, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)3); // uid 18660, Toti Class (1075 class)
        setSpecific((byte)2); // uid 18662, S 513 Enrico Dandolo
    }
}
