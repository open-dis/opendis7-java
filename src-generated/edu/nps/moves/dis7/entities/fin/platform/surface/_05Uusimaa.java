package edu.nps.moves.dis7.entities.fin.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2f465398
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23030
 */
public class _05Uusimaa extends EntityType
{
    public _05Uusimaa()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 23027, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 23028, Hameenmaa Class
        setSpecific((byte)2); // uid 23030, 05 Uusimaa
    }
}
