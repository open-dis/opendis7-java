package edu.nps.moves.dis7.entities.can.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@210366b4
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30994
 */
public class LAVIIITOWUnderArmourTUA extends EntityType
{
    public LAVIIITOWUnderArmourTUA()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 30991, Armored Fighting Vehicle
        setSubCategory((byte)1); // uid 30992, Light Armoured Vehicle (LAV) III
        setSpecific((byte)2); // uid 30994, LAV III TOW Under Armour (TUA)
    }
}
