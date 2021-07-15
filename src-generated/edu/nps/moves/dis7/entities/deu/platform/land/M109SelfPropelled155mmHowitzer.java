package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@f68f0dc;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22758
 */
public class M109SelfPropelled155mmHowitzer extends EntityType
{
    /** Default constructor */
    public M109SelfPropelled155mmHowitzer()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 16273, Self-Propelled Artillery
        setSubCategory((byte)2); // uid 22758, M109 Self-Propelled 155 mm Howitzer
    }
}
