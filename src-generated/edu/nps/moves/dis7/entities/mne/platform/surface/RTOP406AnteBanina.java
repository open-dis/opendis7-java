package edu.nps.moves.dis7.entities.mne.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@bc57b40
 * Country: Montenegro (MNE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30137
 */
public class RTOP406AnteBanina extends EntityType
{
    public RTOP406AnteBanina()
    {
        setCountry(Country.MONTENEGRO_MNE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)64); // uid 30134, Fast Attack Craft
        setSubCategory((byte)1); // uid 30135, Koncar Class
        setSpecific((byte)2); // uid 30137, RTOP-406 Ante Banina
    }
}
