package edu.nps.moves.dis7.entities.ser.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2cee5365;
 * Country: Serbia and Montenegro;
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 26968
 */
public class _82mmRecoillessAmmunition extends EntityType
{
    /** Default constructor */
    public _82mmRecoillessAmmunition()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 26967, Ballistic
        setSubCategory((byte)1); // uid 26968, 82mm Recoilless Ammunition
    }
}
