package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1996cd68
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 29754
 */
public class MANSX45RecoveryWithHaulmarkTrailerHeavyEquipment extends EntityType
{
    public MANSX45RecoveryWithHaulmarkTrailerHeavyEquipment()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 29715, Large Wheeled Utility Vehicle
        setSubCategory((byte)5); // uid 29753, MAN SX45 - 8x8
        setSpecific((byte)1); // uid 29754, MAN SX45 Recovery, With Haulmark - Trailer, Heavy Equipment
    }
}
