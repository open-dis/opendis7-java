package edu.nps.moves.dis7.entities.afg.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@5fa0141f
 * Country: Afghanistan (AFG)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32180
 */
public class AfghanNationalArmyANA extends EntityType
{
    public AfghanNationalArmyANA()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)11); // uid 32180, Afghan National Army (ANA)
    }
}
