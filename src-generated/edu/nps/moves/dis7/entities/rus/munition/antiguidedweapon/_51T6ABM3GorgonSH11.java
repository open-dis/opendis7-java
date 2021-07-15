package edu.nps.moves.dis7.entities.rus.munition.antiguidedweapon;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@59e7564b;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: ANTI_GUIDED_WEAPON;
 *
 * Entity type uid: 20503
 */
public class _51T6ABM3GorgonSH11 extends EntityType
{
    /** Default constructor */
    public _51T6ABM3GorgonSH11()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_GUIDED_WEAPON));

        setCategory((byte)1); // uid 20499, Guided
        setSubCategory((byte)1); // uid 20500, SH-01 Galosh (UR-96)
        setSpecific((byte)3); // uid 20503, 51T6 (ABM-3 Gorgon / SH-11)
    }
}
