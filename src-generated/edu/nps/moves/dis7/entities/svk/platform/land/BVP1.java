package edu.nps.moves.dis7.entities.svk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1729ec00;
 * Country: Slovakia (SVK);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 30118
 */
public class BVP1 extends EntityType
{
    /** Default constructor */
    public BVP1()
    {
        setCountry(Country.SLOVAKIA_SVK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 30117, Armored Fighting Vehicle
        setSubCategory((byte)1); // uid 30118, BVP-1
    }
}
