package edu.nps.moves.dis7.entities.grc.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@55493582
 * Country: Greece (GRC)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 22793
 */
public class Leopard2MBT extends EntityType
{
    public Leopard2MBT()
    {
        setCountry(Country.GREECE_GRC);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 22792, Tank
        setSubCategory((byte)1); // uid 22793, Leopard 2 MBT
    }
}
