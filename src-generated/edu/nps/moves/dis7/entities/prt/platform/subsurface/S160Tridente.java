package edu.nps.moves.dis7.entities.prt.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5ffc5491;
 * Country: Portugal (PRT);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 23101
 */
public class S160Tridente extends EntityType
{
    /** Default constructor */
    public S160Tridente()
    {
        setCountry(Country.PORTUGAL_PRT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 23099, SS (Conventional Attack - Torpedo, Patrol)
        setSubCategory((byte)1); // uid 23100, Type 209PN class
        setSpecific((byte)1); // uid 23101, S160 Tridente
    }
}
