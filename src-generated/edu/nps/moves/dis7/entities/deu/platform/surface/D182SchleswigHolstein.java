package edu.nps.moves.dis7.entities.deu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6d7fc27
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 16396
 */
public class D182SchleswigHolstein extends EntityType
{
    public D182SchleswigHolstein()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)5); // uid 16392, Destroyer
        setSubCategory((byte)2); // uid 16394, Hamburg class (Type 101A)
        setSpecific((byte)2); // uid 16396, D182 Schleswig-Holstein
    }
}
