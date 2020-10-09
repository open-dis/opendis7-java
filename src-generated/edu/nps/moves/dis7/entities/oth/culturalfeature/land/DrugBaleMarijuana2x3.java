package edu.nps.moves.dis7.entities.oth.culturalfeature.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@152e7703
 * Country: Other
 * Entity kind: Cultural feature
 * Domain: LAND
 *
 * Entity type uid: 28514
 */
public class DrugBaleMarijuana2x3 extends EntityType
{
    public DrugBaleMarijuana2x3()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 28511, Contraband
        setSubCategory((byte)1); // uid 28512, Drug Bale
        setSpecific((byte)1); // uid 28513, Drug Bale, Marijuana
        setExtra((byte)1); // uid 28514, Drug Bale, Marijuana, 2x3
    }
}
