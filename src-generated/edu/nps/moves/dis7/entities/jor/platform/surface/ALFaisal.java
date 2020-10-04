package edu.nps.moves.dis7.entities.jor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2a65bb85
 * Country: Jordan (JOR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18275
 */
public class ALFaisal extends EntityType
{
    public ALFaisal()
    {
        setCountry(Country.JORDAN_JOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 18272, Landing Craft
        setSubCategory((byte)1); // uid 18273, AL Hashim (Rotork) Class (LCU)
        setSpecific((byte)2); // uid 18275, AL Faisal
    }
}
