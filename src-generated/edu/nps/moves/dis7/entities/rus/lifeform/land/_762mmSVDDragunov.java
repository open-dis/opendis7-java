package edu.nps.moves.dis7.entities.rus.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@36238b12
 * Country: Russia (RUS)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32141
 */
public class _762mmSVDDragunov extends EntityType
{
    public _762mmSVDDragunov()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)11); // uid 32132, Army
        setSubCategory((byte)15); // uid 32140, Sniper Rifles
        setSpecific((byte)40); // uid 32141, 7.62mm SVD (Dragunov)
    }
}
