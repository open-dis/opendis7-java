package edu.nps.moves.dis7.entities.prk.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@77c66a4f
 * Country: Korea (Democratic Peoples Republic of) (PRK)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32505
 */
public class ScudDSeparatedWarhead extends EntityType
{
    public ScudDSeparatedWarhead()
    {
        setCountry(Country.KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32499, Guided
        setSubCategory((byte)14); // uid 32504, Scud-D (SS-1E)
        setSpecific((byte)1); // uid 32505, Scud-D Separated Warhead
    }
}
