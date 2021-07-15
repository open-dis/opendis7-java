package edu.nps.moves.dis7.entities.brn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1794d431;
 * Country: Brunei Darussalam (BRN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28183
 */
public class _06Darussalam extends EntityType
{
    /** Default constructor */
    public _06Darussalam()
    {
        setCountry(Country.BRUNEI_DARUSSALAM_BRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 28181, Light/Patrol Craft
        setSubCategory((byte)1); // uid 28182, Darussalam Class
        setSpecific((byte)1); // uid 28183, 06 Darussalam
    }
}
