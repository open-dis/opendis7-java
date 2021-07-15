package edu.nps.moves.dis7.entities.chn.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5111de7c;
 * Country: China, Peoples Republic of (CHN);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 21579
 */
public class Jettisonedfirststage extends EntityType
{
    /** Default constructor */
    public Jettisonedfirststage()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)2); // uid 21575, Ballistic
        setSubCategory((byte)1); // uid 21576, DF-15 (M-9)
        setSpecific((byte)4); // uid 21579, Jettisoned first stage
    }
}