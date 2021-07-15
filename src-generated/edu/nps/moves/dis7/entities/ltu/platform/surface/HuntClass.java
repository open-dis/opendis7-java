package edu.nps.moves.dis7.entities.ltu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2a76b80a;
 * Country: Lithuania (LTU);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31794
 */
public class HuntClass extends EntityType
{
    /** Default constructor */
    public HuntClass()
    {
        setCountry(Country.LITHUANIA_LTU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27782, Mine Countermeasure Ship/Craft
        setSubCategory((byte)2); // uid 31794, Hunt Class
    }
}
