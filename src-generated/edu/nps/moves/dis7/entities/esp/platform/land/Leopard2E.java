package edu.nps.moves.dis7.entities.esp.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4edef76c
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 22790
 */
public class Leopard2E extends EntityType
{
    public Leopard2E()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 22788, Tank
        setSubCategory((byte)1); // uid 22789, Leopard 2 MBT
        setSpecific((byte)1); // uid 22790, Leopard 2E
    }
}
