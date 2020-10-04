package edu.nps.moves.dis7.entities.mne.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@200a26bc
 * Country: Montenegro (MNE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30136
 */
public class RTOP405JordanNikolovOrce extends EntityType
{
    public RTOP405JordanNikolovOrce()
    {
        setCountry(Country.MONTENEGRO_MNE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)64); // uid 30134, Fast Attack Craft
        setSubCategory((byte)1); // uid 30135, Koncar Class
        setSpecific((byte)1); // uid 30136, RTOP-405 Jordan Nikolov Orce
    }
}
