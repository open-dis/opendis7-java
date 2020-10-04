package edu.nps.moves.dis7.entities.afg.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@619a5dff
 * Country: Afghanistan (AFG)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31163
 */
public class UtilityEmergencyCar extends EntityType
{
    public UtilityEmergencyCar()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)93); // uid 31163, Utility/Emergency Car
    }
}
