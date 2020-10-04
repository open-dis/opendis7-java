package edu.nps.moves.dis7.entities.dza.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@61e717c2
 * Country: Algeria (DZA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27737
 */
public class _342ElMorakeb extends EntityType
{
    public _342ElMorakeb()
    {
        setCountry(Country.ALGERIA_DZA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 27023, Light/Patrol Craft
        setSubCategory((byte)2); // uid 27735, Kebir Class
        setSpecific((byte)2); // uid 27737, 342 El Morakeb
    }
}
