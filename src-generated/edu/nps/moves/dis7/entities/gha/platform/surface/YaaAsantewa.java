package edu.nps.moves.dis7.entities.gha.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@b2c5e07
 * Country: Ghana (GHA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27504
 */
public class YaaAsantewa extends EntityType
{
    public YaaAsantewa()
    {
        setCountry(Country.GHANA_GHA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 27501, Light/Patrol Craft
        setSubCategory((byte)1); // uid 27502, Albatros Class (Type 143/143B)
        setSpecific((byte)2); // uid 27504, Yaa Asantewa
    }
}
