package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@5b5dce5c;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 27356
 */
public class M1080TruckChassisLMTVwMK19GrenadeMachineGun extends EntityType
{
    /** Default constructor */
    public M1080TruckChassisLMTVwMK19GrenadeMachineGun()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 10418, Large Wheeled Utility Vehicle
        setSubCategory((byte)12); // uid 10481, Stewart & Stevenson Family of Medium Tactical Vehicles (FMTV)
        setSpecific((byte)5); // uid 10486, M1080 Truck, Chassis; LMTV w/ Equip
        setExtra((byte)1); // uid 27356, M1080 Truck, Chassis; LMTV w/ MK19 Grenade Machine Gun
    }
}
