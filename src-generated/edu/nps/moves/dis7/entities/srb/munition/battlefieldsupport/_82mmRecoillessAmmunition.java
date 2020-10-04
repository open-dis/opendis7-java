package edu.nps.moves.dis7.entities.srb.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@762bf32d
 * Country: Serbia (SRB)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 30185
 */
public class _82mmRecoillessAmmunition extends EntityType
{
    public _82mmRecoillessAmmunition()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 30184, Ballistic
        setSubCategory((byte)1); // uid 30185, 82mm Recoilless Ammunition
    }
}
