package edu.nps.moves.dis7.entities.jor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@ab7a938;
 * Country: Jordan (JOR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 18269
 */
public class _101ALHussein extends EntityType
{
    /** Default constructor */
    public _101ALHussein()
    {
        setCountry(Country.JORDAN_JOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18262, Light/Patrol Craft
        setSubCategory((byte)2); // uid 18268, AL Hussein (Hawk) Class (fast attack craft-gun)
        setSpecific((byte)1); // uid 18269, 101 AL Hussein
    }
}
