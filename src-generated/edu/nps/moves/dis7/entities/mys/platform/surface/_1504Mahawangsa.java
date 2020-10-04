package edu.nps.moves.dis7.entities.mys.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@51f49060
 * Country: Malaysia (MYS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27406
 */
public class _1504Mahawangsa extends EntityType
{
    public _1504Mahawangsa()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27403, Auxiliary
        setSubCategory((byte)1); // uid 27404, Indera Sakti Class
        setSpecific((byte)2); // uid 27406, 1504 Mahawangsa
    }
}
