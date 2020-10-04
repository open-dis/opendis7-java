package edu.nps.moves.dis7.entities.oth.supply.class12slingloadsnondoctrinal;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@48af5f38
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_12_SLING_LOADS_NON_DOCTRINAL
 *
 * Entity type uid: 30821
 */
public class SlingLoadCrate extends EntityType
{
    public SlingLoadCrate()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_12_SLING_LOADS_NON_DOCTRINAL));

        setCategory((byte)3); // uid 30821, Sling Load, Crate
    }
}
