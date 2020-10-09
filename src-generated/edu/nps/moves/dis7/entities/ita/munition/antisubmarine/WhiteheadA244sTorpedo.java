package edu.nps.moves.dis7.entities.ita.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@79cb8ffa
 * Country: Italy (ITA)
 * Entity kind: Munition
 * Domain: ANTI_SUBMARINE
 *
 * Entity type uid: 21688
 */
public class WhiteheadA244sTorpedo extends EntityType
{
    public WhiteheadA244sTorpedo()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)1); // uid 21684, Guided
        setSubCategory((byte)4); // uid 21688, Whitehead A-244/s Torpedo
    }
}
