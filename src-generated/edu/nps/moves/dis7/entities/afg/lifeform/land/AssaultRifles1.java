package edu.nps.moves.dis7.entities.afg.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@8ac512e
 * Country: Afghanistan (AFG)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32192
 */
public class AssaultRifles1 extends EntityType
{
    public AssaultRifles1()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)52); // uid 32188, Afghan National Police (ANP)
        setSubCategory((byte)5); // uid 32192, Assault Rifles
    }
}
