package edu.nps.moves.dis7.entities.afg.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@740c4868
 * Country: Afghanistan (AFG)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32221
 */
public class PersonalElectronics1 extends EntityType
{
    public PersonalElectronics1()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)133); // uid 32220, Press
        setSubCategory((byte)171); // uid 32221, Personal Electronics
    }
}
