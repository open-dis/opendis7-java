package edu.nps.moves.dis7.entities.irq.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@3fb6cf60
 * Country: Iraq (IRQ)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 17986
 */
public class ArmoredFightingVehicle extends EntityType
{
    public ArmoredFightingVehicle()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 17986, Armored Fighting Vehicle
    }
}
