package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@39ed3c8d;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29729
 */
public class MANHX58RecoveryWithArmouredCab extends EntityType
{
    /** Default constructor */
    public MANHX58RecoveryWithArmouredCab()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 29715, Large Wheeled Utility Vehicle
        setSubCategory((byte)2); // uid 29728, MAN HX58 - 6x6, Recovery
        setSpecific((byte)1); // uid 29729, MAN HX58 - Recovery, With Armoured Cab
    }
}
