package edu.nps.moves.dis7.entities.est.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6ab778a
 * Country: Estonia (EST)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27564
 */
public class FrauenlobClassType394 extends EntityType
{
    public FrauenlobClassType394()
    {
        setCountry(Country.ESTONIA_EST);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27555, Mine Countermeasure Ship/Craft
        setSubCategory((byte)3); // uid 27564, Frauenlob Class (Type 394)
    }
}
