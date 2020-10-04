package edu.nps.moves.dis7.entities.svk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7a8406c2
 * Country: Slovakia (SVK)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27908
 */
public class BOZENA4MMCSMiniMineClearanceSystem extends EntityType
{
    public BOZENA4MMCSMiniMineClearanceSystem()
    {
        setCountry(Country.SLOVAKIA_SVK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)11); // uid 27907, Mine Plow
        setSubCategory((byte)1); // uid 27908, BOZENA-4 MMCS (Mini Mine Clearance System)
    }
}
