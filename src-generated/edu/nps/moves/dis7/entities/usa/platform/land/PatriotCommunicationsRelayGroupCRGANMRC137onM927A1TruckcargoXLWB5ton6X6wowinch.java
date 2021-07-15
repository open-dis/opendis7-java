package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@4887de2b;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22969
 */
public class PatriotCommunicationsRelayGroupCRGANMRC137onM927A1TruckcargoXLWB5ton6X6wowinch extends EntityType
{
    /** Default constructor */
    public PatriotCommunicationsRelayGroupCRGANMRC137onM927A1TruckcargoXLWB5ton6X6wowinch()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 10679, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 10691, MIM-104 Raytheon Patriot High-to-Medium Altitude Air Defense (HIMAD) System
        setSpecific((byte)3); // uid 22963, Patriot Communications Relay Group
        setExtra((byte)1); // uid 22969, Patriot Communications Relay Group (CRG), AN/MRC-137 on M927A1 Truck, cargo, XLWB, 5-ton, 6 X 6, w/o winch
    }
}
