package edu.nps.moves.dis7.entities.oth.supply.class12slingloadsnondoctrinal;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@595ec862;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_12_SLING_LOADS_NON_DOCTRINAL;
 *
 * Entity type uid: 30862
 */
public class SlingLoadCH146Griffon extends EntityType
{
    /** Default constructor */
    public SlingLoadCH146Griffon()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_12_SLING_LOADS_NON_DOCTRINAL));

        setCategory((byte)10); // uid 30858, Sling Load, Helicopters
        setSubCategory((byte)1); // uid 30859, Sling Load, Apache AH-64
        setSpecific((byte)3); // uid 30862, Sling Load, CH-146 Griffon
    }
}
