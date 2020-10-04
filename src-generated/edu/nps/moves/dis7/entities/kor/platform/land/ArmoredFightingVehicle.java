package edu.nps.moves.dis7.entities.kor.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@403132fc
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 17623
 */
public class ArmoredFightingVehicle extends EntityType
{
    public ArmoredFightingVehicle()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 17623, Armored Fighting Vehicle
    }
}
