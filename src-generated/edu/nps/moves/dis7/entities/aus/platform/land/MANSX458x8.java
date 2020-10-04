package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3339ad8e
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29753
 */
public class MANSX458x8 extends EntityType
{
    public MANSX458x8()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 29715, Large Wheeled Utility Vehicle
        setSubCategory((byte)5); // uid 29753, MAN SX45 - 8x8
    }
}
