package edu.nps.moves.dis7.entities.ser.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@63485d7;
 * Country: Serbia and Montenegro;
 * Entity kind: Munition;
 * Domain: ANTI_ARMOR;
 *
 * Entity type uid: 26964
 */
public class _82mmRecoillessAmmunition extends EntityType
{
    /** Default constructor */
    public _82mmRecoillessAmmunition()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 26963, Ballistic
        setSubCategory((byte)1); // uid 26964, 82mm Recoilless Ammunition
    }
}
