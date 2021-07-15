package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@26350ea2;
 * Country: United Arab Emirates (ARE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 29499
 */
public class M01AlHasbah extends EntityType
{
    /** Default constructor */
    public M01AlHasbah()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29497, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 29498, Frankenthal Class (Type 332 Minehunter)
        setSpecific((byte)1); // uid 29499, M01 Al Hasbah
    }
}
