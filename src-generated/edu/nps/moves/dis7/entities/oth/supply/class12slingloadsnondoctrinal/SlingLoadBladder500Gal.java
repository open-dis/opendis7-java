package edu.nps.moves.dis7.entities.oth.supply.class12slingloadsnondoctrinal;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@51e94b7d
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_12_SLING_LOADS_NON_DOCTRINAL
 *
 * Entity type uid: 30850
 */
public class SlingLoadBladder500Gal extends EntityType
{
    public SlingLoadBladder500Gal()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_12_SLING_LOADS_NON_DOCTRINAL));

        setCategory((byte)8); // uid 30849, Sling Load, Bladder
        setSubCategory((byte)1); // uid 30850, Sling Load, Bladder, 500 Gal
    }
}
