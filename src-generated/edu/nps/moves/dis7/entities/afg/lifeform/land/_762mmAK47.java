package edu.nps.moves.dis7.entities.afg.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7b3a6e95
 * Country: Afghanistan (AFG)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32185
 */
public class _762mmAK47 extends EntityType
{
    public _762mmAK47()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)11); // uid 32180, Afghan National Army (ANA)
        setSubCategory((byte)5); // uid 32181, Assault Rifles
        setSpecific((byte)112); // uid 32185, 7.62mm AK-47
    }
}
