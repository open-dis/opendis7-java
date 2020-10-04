package edu.nps.moves.dis7.entities.rus.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6ed51944
 * Country: Russia (RUS)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 32154
 */
public class _40mmGS777PSRL2 extends EntityType
{
    public _40mmGS777PSRL2()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)11); // uid 32132, Army
        setSubCategory((byte)45); // uid 32145, Anti-Tank Rockets
        setSpecific((byte)112); // uid 32154, 40mm GS-777/PSRL-2
    }
}
