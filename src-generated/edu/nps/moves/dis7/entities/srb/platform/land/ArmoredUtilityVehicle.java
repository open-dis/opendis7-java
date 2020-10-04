package edu.nps.moves.dis7.entities.srb.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@a7ad6e5
 * Country: Serbia (SRB)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30152
 */
public class ArmoredUtilityVehicle extends EntityType
{
    public ArmoredUtilityVehicle()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 30152, Armored Utility Vehicle
    }
}
