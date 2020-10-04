package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@1991f767
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24895
 */
public class NissanMidSizePickupwBoxes extends EntityType
{
    public NissanMidSizePickupwBoxes()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)83); // uid 24879, Single Unit Cargo Truck
        setSubCategory((byte)2); // uid 24889, Pickup Truck, Mid-Size
        setSpecific((byte)2); // uid 24894, Nissan Mid-Size Pickup
        setExtra((byte)1); // uid 24895, Nissan Mid-Size Pickup w/ Boxes
    }
}
