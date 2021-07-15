package edu.nps.moves.dis7.entities.oth.culturalfeature.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@9f1ca74;
 * Country: Other;
 * Entity kind: Cultural feature;
 * Domain: LAND;
 *
 * Entity type uid: 28515
 */
public class DrugBaleCocaine extends EntityType
{
    /** Default constructor */
    public DrugBaleCocaine()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 28511, Contraband
        setSubCategory((byte)1); // uid 28512, Drug Bale
        setSpecific((byte)2); // uid 28515, Drug Bale, Cocaine
    }
}
