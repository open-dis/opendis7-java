package edu.nps.moves.dis7.entities.bra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@20e2cbe0;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 25700
 */
public class EmbraerEMB145MULTIINTELR99BR99 extends EntityType
{
    /** Default constructor */
    public EmbraerEMB145MULTIINTELR99BR99()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 25698, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)2); // uid 25700, Embraer EMB 145 MULTI INTEL (R-99B/R-99)
    }
}
