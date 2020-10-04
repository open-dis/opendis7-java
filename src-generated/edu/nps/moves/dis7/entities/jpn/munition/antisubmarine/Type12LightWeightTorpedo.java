package edu.nps.moves.dis7.entities.jpn.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@489110c2
 * Country: Japan (JPN)
 * Entity kind: Munition
 * Domain: ANTI_SUBMARINE
 *
 * Entity type uid: 30227
 */
public class Type12LightWeightTorpedo extends EntityType
{
    public Type12LightWeightTorpedo()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)1); // uid 30226, Guided
        setSubCategory((byte)1); // uid 30227, Type 12 Light Weight Torpedo
    }
}
