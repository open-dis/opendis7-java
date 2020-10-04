package edu.nps.moves.dis7.entities.bra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@3f49dace
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19351
 */
public class LargeWheeledUtilityVehicle extends EntityType
{
    public LargeWheeledUtilityVehicle()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19351, Large Wheeled Utility Vehicle
    }
}
