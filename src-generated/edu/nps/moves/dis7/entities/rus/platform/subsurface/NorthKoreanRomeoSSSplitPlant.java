package edu.nps.moves.dis7.entities.rus.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@58860997;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 14805
 */
public class NorthKoreanRomeoSSSplitPlant extends EntityType
{
    /** Default constructor */
    public NorthKoreanRomeoSSSplitPlant()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 14799, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)4); // uid 14803, Romeo class
        setSpecific((byte)2); // uid 14805, (North Korean Romeo SS (Split Plant))
    }
}