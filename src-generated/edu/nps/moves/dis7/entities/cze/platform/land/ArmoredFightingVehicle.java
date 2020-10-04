package edu.nps.moves.dis7.entities.cze.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@a1153bc
 * Country: Czech Republic (CZE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30076
 */
public class ArmoredFightingVehicle extends EntityType
{
    public ArmoredFightingVehicle()
    {
        setCountry(Country.CZECH_REPUBLIC_CZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 30076, Armored Fighting Vehicle
    }
}
