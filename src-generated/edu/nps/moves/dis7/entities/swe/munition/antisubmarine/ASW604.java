package edu.nps.moves.dis7.entities.swe.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7c5f29c6;
 * Country: Sweden (SWE);
 * Entity kind: Munition;
 * Domain: ANTI_SUBMARINE;
 *
 * Entity type uid: 27017
 */
public class ASW604 extends EntityType
{
    /** Default constructor */
    public ASW604()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)2); // uid 27012, Ballistic
        setSubCategory((byte)1); // uid 27013, Elma Anti-Submarine Mortar
        setSpecific((byte)4); // uid 27017, ASW-604
    }
}
