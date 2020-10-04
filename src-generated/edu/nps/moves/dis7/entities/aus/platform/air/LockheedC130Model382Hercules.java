package edu.nps.moves.dis7.entities.aus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1ef7fe8e
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29305
 */
public class LockheedC130Model382Hercules extends EntityType
{
    public LockheedC130Model382Hercules()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 17505, Cargo/Tanker
        setSubCategory((byte)2); // uid 29305, Lockheed C-130 (Model 382) Hercules
    }
}
