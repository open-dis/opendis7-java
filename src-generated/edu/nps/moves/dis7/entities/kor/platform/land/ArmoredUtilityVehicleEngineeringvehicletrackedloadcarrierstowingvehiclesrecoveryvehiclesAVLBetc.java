package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@2cab9998
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23757
 */
public class ArmoredUtilityVehicleEngineeringvehicletrackedloadcarrierstowingvehiclesrecoveryvehiclesAVLBetc extends EntityType
{
    public ArmoredUtilityVehicleEngineeringvehicletrackedloadcarrierstowingvehiclesrecoveryvehiclesAVLBetc()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 23757, Armored Utility Vehicle - (Engineering vehicle, tracked load carriers, towing vehicles, recovery vehicles, AVLB, etc.)
    }
}
