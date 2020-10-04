package edu.nps.moves.dis7.entities.swe.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2b098563
 * Country: Sweden (SWE)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 27303
 */
public class RBS15MMk1SSMNaval extends EntityType
{
    public RBS15MMk1SSMNaval()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 27301, Guided
        setSubCategory((byte)1); // uid 27302, RBS-15 (SSM/ASM)
        setSpecific((byte)1); // uid 27303, RBS-15M Mk1 (SSM Naval)
    }
}
