package edu.nps.moves.dis7.entities.usa.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1b7f06c7
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 11446
 */
public class DDG909ChinYangexMullanyDD528Taiwan extends EntityType
{
    public DDG909ChinYangexMullanyDD528Taiwan()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)4); // uid 11372, Guided Missile Destroyer
        setSubCategory((byte)6); // uid 11443, Fletcher and Allen M Summer Class
        setSpecific((byte)3); // uid 11446, DDG 909 Chin Yang (ex. Mullany DD 528) (Taiwan)
    }
}
