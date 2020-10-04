package edu.nps.moves.dis7.entities.pol.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7882c44a
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31681
 */
public class Leopard2A5 extends EntityType
{
    public Leopard2A5()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 25540, Tank
        setSubCategory((byte)2); // uid 31679, Leopard 2 MBT
        setSpecific((byte)2); // uid 31681, Leopard 2 A5
    }
}
