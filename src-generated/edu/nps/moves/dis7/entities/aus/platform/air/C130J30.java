package edu.nps.moves.dis7.entities.aus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@de0a01f
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29307
 */
public class C130J30 extends EntityType
{
    public C130J30()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 17505, Cargo/Tanker
        setSubCategory((byte)2); // uid 29305, Lockheed C-130 (Model 382) Hercules
        setSpecific((byte)1); // uid 29306, C-130
        setExtra((byte)1); // uid 29307, C-130J-30
    }
}
