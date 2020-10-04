package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@e2d56bf
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31706
 */
public class M113AS4ArmoredEngineeringVehicleENG extends EntityType
{
    public M113AS4ArmoredEngineeringVehicleENG()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 26901, Armored Fighting Vehicle
        setSubCategory((byte)3); // uid 28616, M113-AS4 Armored Personnel Carrier (APC)
        setSpecific((byte)2); // uid 31706, M113-AS4 Armored Engineering Vehicle (ENG)
    }
}
