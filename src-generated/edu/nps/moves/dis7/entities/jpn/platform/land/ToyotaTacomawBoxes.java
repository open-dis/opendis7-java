package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@2488b073
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 24901
 */
public class ToyotaTacomawBoxes extends EntityType
{
    public ToyotaTacomawBoxes()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)83); // uid 24879, Single Unit Cargo Truck
        setSubCategory((byte)5); // uid 24898, Pickup Truck, Extended Cab
        setSpecific((byte)1); // uid 24899, Toyota Tacoma
        setExtra((byte)2); // uid 24901, Toyota Tacoma w/ Boxes
    }
}
