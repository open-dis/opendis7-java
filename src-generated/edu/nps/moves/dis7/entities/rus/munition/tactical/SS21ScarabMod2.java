package edu.nps.moves.dis7.entities.rus.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@ff0e6d4
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32405
 */
public class SS21ScarabMod2 extends EntityType
{
    public SS21ScarabMod2()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 27168, Guided
        setSubCategory((byte)6); // uid 32405, SS-21 Scarab Mod-2
    }
}
