package edu.nps.moves.dis7.entities.cpv.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6f1fba17
 * Country: Cabo Verde (CPV)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27570
 */
public class P521Vigilante extends EntityType
{
    public P521Vigilante()
    {
        setCountry(Country.CABO_VERDE_CPV);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27568, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27569, Kondor I Class
        setSpecific((byte)1); // uid 27570, P 521 Vigilante
    }
}
