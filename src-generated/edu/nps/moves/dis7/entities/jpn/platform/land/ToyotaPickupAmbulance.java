package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5ddabb18;
 * Country: Japan (JPN);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31831
 */
public class ToyotaPickupAmbulance extends EntityType
{
    /** Default constructor */
    public ToyotaPickupAmbulance()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)84); // uid 31829, Single Unit Utility/Emergency Truck
        setSubCategory((byte)4); // uid 31830, Ambulance Pickup Truck
        setSpecific((byte)1); // uid 31831, Toyota Pickup Ambulance
    }
}
