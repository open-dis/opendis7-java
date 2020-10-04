package edu.nps.moves.dis7.entities.aus.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@a357c3e
 * Country: Australia (AUS)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 31570
 */
public class _127mmAW50F1 extends EntityType
{
    public _127mmAW50F1()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)30); // uid 31543, Australian Special Operations Command (SOCOMD)
        setSubCategory((byte)17); // uid 31569, Anti-Materiel Rifle (AMR)
        setSpecific((byte)11); // uid 31570, 12.7mm AW50F
    }
}
