package edu.nps.moves.dis7.entities.swe.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1187dc82
 * Country: Sweden (SWE)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 27453
 */
public class _57mm3PPrefragmentedProgrammableProximity extends EntityType
{
    public _57mm3PPrefragmentedProgrammableProximity()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 21657, Ballistic
        setSubCategory((byte)3); // uid 27452, 57 mm
        setSpecific((byte)1); // uid 27453, 57 mm 3P (Prefragmented Programmable Proximity)
    }
}
