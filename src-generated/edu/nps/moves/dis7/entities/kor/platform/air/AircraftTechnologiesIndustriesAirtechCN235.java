package edu.nps.moves.dis7.entities.kor.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@15a902e7
 * Country: Korea (Republic of) (KOR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 17627
 */
public class AircraftTechnologiesIndustriesAirtechCN235 extends EntityType
{
    public AircraftTechnologiesIndustriesAirtechCN235()
    {
        setCountry(Country.KOREA_REPUBLIC_OF_KOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 17626, Cargo/Tanker
        setSubCategory((byte)1); // uid 17627, Aircraft Technologies Industries (Airtech) CN-235
    }
}
