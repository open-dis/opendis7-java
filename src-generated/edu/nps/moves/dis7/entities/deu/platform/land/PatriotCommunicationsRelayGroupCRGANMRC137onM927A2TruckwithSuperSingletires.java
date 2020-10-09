package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@2462cb01
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 28107
 */
public class PatriotCommunicationsRelayGroupCRGANMRC137onM927A2TruckwithSuperSingletires extends EntityType
{
    public PatriotCommunicationsRelayGroupCRGANMRC137onM927A2TruckwithSuperSingletires()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 16321, Air Defense/Missile Defense Unit Equipment
        setSubCategory((byte)4); // uid 28096, MIM-104 Raytheon Patriot High-to-Medium Altitude Air Defense (HIMAD)
        setSpecific((byte)3); // uid 28105, Patriot Communications Relay Group GE
        setExtra((byte)2); // uid 28107, Patriot Communications Relay Group (CRG), AN/MRC-137 on M927A2 Truck with Super Single tires
    }
}
