package edu.nps.moves.dis7.entities.pol.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3c443976
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23034
 */
public class _272GeneralKazmierzPulaski extends EntityType
{
    public _272GeneralKazmierzPulaski()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 23032, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 23033, Oliver Perry Class
        setSpecific((byte)1); // uid 23034, 272 General Kazmierz Pulaski
    }
}
