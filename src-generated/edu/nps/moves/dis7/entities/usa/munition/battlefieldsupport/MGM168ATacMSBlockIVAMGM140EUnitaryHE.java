package edu.nps.moves.dis7.entities.usa.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7c4d1c7b;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 19934
 */
public class MGM168ATacMSBlockIVAMGM140EUnitaryHE extends EntityType
{
    /** Default constructor */
    public MGM168ATacMSBlockIVAMGM140EUnitaryHE()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)1); // uid 19887, Guided
        setSubCategory((byte)17); // uid 19929, MGM-140 Army Tactical Missile System (ATacMS)
        setSpecific((byte)5); // uid 19934, MGM-168 ATacMS - Block IVA (MGM-140E, Unitary HE)
    }
}
