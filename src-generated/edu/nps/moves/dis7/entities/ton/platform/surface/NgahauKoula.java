package edu.nps.moves.dis7.entities.ton.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6c0e13b7
 * Country: Tonga (TON)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 32548
 */
public class NgahauKoula extends EntityType
{
    public NgahauKoula()
    {
        setCountry(Country.TONGA_TON);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26717, Light/Patrol Craft
        setSubCategory((byte)2); // uid 32547, Guardian Class, Pacific Patrol Boats (PPB-R)
        setSpecific((byte)1); // uid 32548, Ngahau Koula
    }
}
