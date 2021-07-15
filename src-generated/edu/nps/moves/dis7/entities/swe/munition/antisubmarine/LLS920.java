package edu.nps.moves.dis7.entities.swe.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@100d0218;
 * Country: Sweden (SWE);
 * Entity kind: Munition;
 * Domain: ANTI_SUBMARINE;
 *
 * Entity type uid: 27014
 */
public class LLS920 extends EntityType
{
    /** Default constructor */
    public LLS920()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)2); // uid 27012, Ballistic
        setSubCategory((byte)1); // uid 27013, Elma Anti-Submarine Mortar
        setSpecific((byte)1); // uid 27014, LLS-920
    }
}
