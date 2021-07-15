package edu.nps.moves.dis7.entities.ita.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2f09e6b2;
 * Country: Italy (ITA);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 21664
 */
public class ASPIDE extends EntityType
{
    /** Default constructor */
    public ASPIDE()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21662, Guided
        setSubCategory((byte)2); // uid 21664, ASPIDE
    }
}
