package edu.nps.moves.dis7.entities.grc.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3c7c886c
 * Country: Greece (GRC)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 22794
 */
public class Leopard2A6HEL extends EntityType
{
    public Leopard2A6HEL()
    {
        setCountry(Country.GREECE_GRC);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 22792, Tank
        setSubCategory((byte)1); // uid 22793, Leopard 2 MBT
        setSpecific((byte)1); // uid 22794, Leopard 2 A6 HEL
    }
}
