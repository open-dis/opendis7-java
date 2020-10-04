package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@51ab1ee3
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 10012
 */
public class McDonnellDouglasHarpoonCoastalDefenseSystem extends EntityType
{
    public McDonnellDouglasHarpoonCoastalDefenseSystem()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)0); // uid 10001, Other
        setSubCategory((byte)3); // uid 10011, Other missile systems
        setSpecific((byte)1); // uid 10012, McDonnell-Douglas Harpoon Coastal Defense System
    }
}
