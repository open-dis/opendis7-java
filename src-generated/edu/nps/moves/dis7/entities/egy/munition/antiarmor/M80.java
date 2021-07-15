package edu.nps.moves.dis7.entities.egy.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@56d6a1b1;
 * Country: Egypt (EGY);
 * Entity kind: Munition;
 * Domain: ANTI_ARMOR;
 *
 * Entity type uid: 24107
 */
public class M80 extends EntityType
{
    /** Default constructor */
    public M80()
    {
        setCountry(Country.COMMENT_RELIABLE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)3); // uid 24106, Fixed
        setSubCategory((byte)1); // uid 24107, M/80
    }
}
