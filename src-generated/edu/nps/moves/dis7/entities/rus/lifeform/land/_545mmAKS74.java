package edu.nps.moves.dis7.entities.rus.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@10b87ff6
 * Country: Russia (RUS)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32135
 */
public class _545mmAKS74 extends EntityType
{
    public _545mmAKS74()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)11); // uid 32132, Army
        setSubCategory((byte)5); // uid 32133, Assault Rifles
        setSpecific((byte)11); // uid 32135, 5.45mm AKS-74
    }
}
