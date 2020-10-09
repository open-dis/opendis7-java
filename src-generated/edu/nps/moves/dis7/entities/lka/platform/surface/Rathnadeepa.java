package edu.nps.moves.dis7.entities.lka.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@302edb74
 * Country: Sri Lanka (LKA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28880
 */
public class Rathnadeepa extends EntityType
{
    public Rathnadeepa()
    {
        setCountry(Country.SRI_LANKA_LKA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26422, Light/Patrol Craft
        setSubCategory((byte)2); // uid 28878, Bay Class Patrol Boat
        setSpecific((byte)2); // uid 28880, Rathnadeepa
    }
}
