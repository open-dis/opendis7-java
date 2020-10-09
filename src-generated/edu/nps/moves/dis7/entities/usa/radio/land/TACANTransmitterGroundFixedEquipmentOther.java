package edu.nps.moves.dis7.entities.usa.radio.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7c8f047a
 * Country: United States of America (USA)
 * Entity kind: Radio
 * Domain: LAND
 *
 * Entity type uid: 22211
 */
public class TACANTransmitterGroundFixedEquipmentOther extends EntityType
{
    public TACANTransmitterGroundFixedEquipmentOther()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)10); // uid 22210, Tactical Air Navigation (TACAN) Transmitter (Ground Fixed Equipment)
        setSubCategory((byte)0); // uid 22211, TACAN Transmitter (Ground Fixed Equipment), Other
    }
}
