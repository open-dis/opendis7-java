package edu.nps.moves.dis7.entities.jpn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7a48e6e2;
 * Country: Japan (JPN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 29270
 */
public class IzumoClassHelicopterDestroyer extends EntityType
{
    /** Default constructor */
    public IzumoClassHelicopterDestroyer()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)13); // uid 28698, Cruiser/Helicopter Carrier
        setSubCategory((byte)2); // uid 29270, Izumo Class Helicopter Destroyer
    }
}
