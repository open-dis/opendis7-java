package edu.nps.moves.dis7.entities.omn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5851bd4f;
 * Country: Oman (OMN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28564
 */
public class Hawk203 extends EntityType
{
    /** Default constructor */
    public Hawk203()
    {
        setCountry(Country.OMAN_OMN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)2); // uid 28562, Attack/Strike
        setSubCategory((byte)1); // uid 28563, BAE Systems Hawk
        setSpecific((byte)1); // uid 28564, Hawk 203
    }
}
