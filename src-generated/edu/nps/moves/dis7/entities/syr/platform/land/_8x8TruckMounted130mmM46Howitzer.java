package edu.nps.moves.dis7.entities.syr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@522bf64e
 * Country: Syrian Arab Republic (SYR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31705
 */
public class _8x8TruckMounted130mmM46Howitzer extends EntityType
{
    public _8x8TruckMounted130mmM46Howitzer()
    {
        setCountry(Country.SYRIAN_ARAB_REPUBLIC_SYR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 31702, Self-Propelled Artillery
        setSubCategory((byte)3); // uid 31705, 8x8 Truck Mounted 130-mm M-46 Howitzer
    }
}
