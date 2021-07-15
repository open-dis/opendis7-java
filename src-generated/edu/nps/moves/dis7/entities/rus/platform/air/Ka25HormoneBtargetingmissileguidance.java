package edu.nps.moves.dis7.entities.rus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5af97169;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 13427
 */
public class Ka25HormoneBtargetingmissileguidance extends EntityType
{
    /** Default constructor */
    public Ka25HormoneBtargetingmissileguidance()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)20); // uid 13407, Attack helicopter
        setSubCategory((byte)4); // uid 13425, Ka-25 Hormone
        setSpecific((byte)2); // uid 13427, Ka-25 Hormone B (targeting & missile guidance)
    }
}
