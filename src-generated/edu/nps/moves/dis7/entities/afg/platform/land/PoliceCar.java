package edu.nps.moves.dis7.entities.afg.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@238e0d81;
 * Country: Afghanistan (AFG);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31164
 */
public class PoliceCar extends EntityType
{
    /** Default constructor */
    public PoliceCar()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)93); // uid 31163, Utility/Emergency Car
        setSubCategory((byte)2); // uid 31164, Police Car
    }
}
