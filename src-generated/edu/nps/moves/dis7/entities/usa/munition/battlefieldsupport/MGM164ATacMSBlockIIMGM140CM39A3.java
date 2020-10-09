package edu.nps.moves.dis7.entities.usa.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@15d88c10
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 19932
 */
public class MGM164ATacMSBlockIIMGM140CM39A3 extends EntityType
{
    public MGM164ATacMSBlockIIMGM140CM39A3()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)1); // uid 19887, Guided
        setSubCategory((byte)17); // uid 19929, MGM-140 Army Tactical Missile System (ATacMS)
        setSpecific((byte)3); // uid 19932, MGM-164 ATacMS - Block II (MGM-140C / M39A3)
    }
}
