package edu.nps.moves.dis7.entities.rus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@652ce654;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 13362
 */
public class Il20CootAELINTreconIl18variant extends EntityType
{
    /** Default constructor */
    public Il20CootAELINTreconIl18variant()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 13350, Cargo/Tanker
        setSubCategory((byte)4); // uid 13361, Il-20/22 Coot
        setSpecific((byte)1); // uid 13362, Il-20 Coot A, ELINT/recon (Il-18 variant)
    }
}
