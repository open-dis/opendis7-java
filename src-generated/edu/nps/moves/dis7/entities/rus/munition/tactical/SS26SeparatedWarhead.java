package edu.nps.moves.dis7.entities.rus.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@50dc49e1;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 32407
 */
public class SS26SeparatedWarhead extends EntityType
{
    /** Default constructor */
    public SS26SeparatedWarhead()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 27168, Guided
        setSubCategory((byte)7); // uid 32406, SS-26 Stone (9K720 Iskander)
        setSpecific((byte)1); // uid 32407, SS-26 Separated Warhead
    }
}
