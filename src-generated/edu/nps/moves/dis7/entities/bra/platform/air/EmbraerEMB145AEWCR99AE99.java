package edu.nps.moves.dis7.entities.bra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4667ae56
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 25699
 */
public class EmbraerEMB145AEWCR99AE99 extends EntityType
{
    public EmbraerEMB145AEWCR99AE99()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 25698, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)1); // uid 25699, Embraer EMB 145 AEW&C (R-99A/E-99)
    }
}
