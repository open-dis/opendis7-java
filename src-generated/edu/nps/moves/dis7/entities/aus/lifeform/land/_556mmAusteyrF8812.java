package edu.nps.moves.dis7.entities.aus.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@11574592
 * Country: Australia (AUS)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 31532
 */
public class _556mmAusteyrF8812 extends EntityType
{
    public _556mmAusteyrF8812()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)14); // uid 31530, Royal Australian Navy (RAN)
        setSubCategory((byte)5); // uid 31531, Assault Rifles
        setSpecific((byte)55); // uid 31532, 5.56mm Austeyr F88
    }
}
