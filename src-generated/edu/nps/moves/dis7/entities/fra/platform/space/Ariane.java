package edu.nps.moves.dis7.entities.fra.platform.space;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@333d4a8c;
 * Country: France (FRA);
 * Entity kind: Platform;
 * Domain: SPACE;
 *
 * Entity type uid: 16238
 */
public class Ariane extends EntityType
{
    /** Default constructor */
    public Ariane()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SPACE));

        setCategory((byte)3); // uid 16237, Booster
        setSubCategory((byte)1); // uid 16238, Ariane
    }
}
