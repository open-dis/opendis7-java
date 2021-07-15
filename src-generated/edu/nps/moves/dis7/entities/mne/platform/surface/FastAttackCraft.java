package edu.nps.moves.dis7.entities.mne.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@6bc248ed;
 * Country: Montenegro (MNE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 30134
 */
public class FastAttackCraft extends EntityType
{
    /** Default constructor */
    public FastAttackCraft()
    {
        setCountry(Country.MONTENEGRO_MNE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)64); // uid 30134, Fast Attack Craft
    }
}
