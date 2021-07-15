package edu.nps.moves.dis7.entities.swe.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@79fd6f95;
 * Country: Sweden (SWE);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 27681
 */
public class SEPSplitterskyddadEnhetsplattformModularArmouredVehicleThor extends EntityType
{
    /** Default constructor */
    public SEPSplitterskyddadEnhetsplattformModularArmouredVehicleThor()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 17470, Armored Fighting Vehicle
        setSubCategory((byte)5); // uid 27681, SEP (Splitterskyddad Enhetsplattform) Modular Armoured Vehicle / Thor
    }
}
