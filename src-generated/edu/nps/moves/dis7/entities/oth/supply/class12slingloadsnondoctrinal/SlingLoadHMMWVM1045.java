package edu.nps.moves.dis7.entities.oth.supply.class12slingloadsnondoctrinal;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@137a4b54
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_12_SLING_LOADS_NON_DOCTRINAL
 *
 * Entity type uid: 30835
 */
public class SlingLoadHMMWVM1045 extends EntityType
{
    public SlingLoadHMMWVM1045()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_12_SLING_LOADS_NON_DOCTRINAL));

        setCategory((byte)5); // uid 30829, Sling Load, Vehicles
        setSubCategory((byte)1); // uid 30830, Sling Load, High Mobility Multipurpose Wheeled Vehicle (HMMWV)
        setSpecific((byte)5); // uid 30835, Sling Load, HMMWV, M1045
    }
}
