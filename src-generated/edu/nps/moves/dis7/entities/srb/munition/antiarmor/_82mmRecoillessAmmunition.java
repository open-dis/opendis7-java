package edu.nps.moves.dis7.entities.srb.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@63de4fa
 * Country: Serbia (SRB)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 30179
 */
public class _82mmRecoillessAmmunition extends EntityType
{
    public _82mmRecoillessAmmunition()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 30178, Ballistic
        setSubCategory((byte)1); // uid 30179, 82mm Recoilless Ammunition
    }
}
