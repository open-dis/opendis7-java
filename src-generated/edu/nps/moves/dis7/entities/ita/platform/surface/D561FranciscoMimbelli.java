package edu.nps.moves.dis7.entities.ita.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@788fcafb
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18340
 */
public class D561FranciscoMimbelli extends EntityType
{
    public D561FranciscoMimbelli()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 18334, Guided Missile Destroyer (DDG)
        setSubCategory((byte)2); // uid 18338, Durand De La Penne Class
        setSpecific((byte)2); // uid 18340, D 561 Francisco Mimbelli
    }
}
