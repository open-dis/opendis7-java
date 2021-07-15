package edu.nps.moves.dis7.entities.oth.supply.class12slingloadsnondoctrinal;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@63c84d31;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_12_SLING_LOADS_NON_DOCTRINAL;
 *
 * Entity type uid: 30859
 */
public class SlingLoadApacheAH64 extends EntityType
{
    /** Default constructor */
    public SlingLoadApacheAH64()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_12_SLING_LOADS_NON_DOCTRINAL));

        setCategory((byte)10); // uid 30858, Sling Load, Helicopters
        setSubCategory((byte)1); // uid 30859, Sling Load, Apache AH-64
    }
}
