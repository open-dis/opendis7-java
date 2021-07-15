package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@368102c8;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31171
 */
public class L118LightGun105mmTowedConfigurationAUS extends EntityType
{
    /** Default constructor */
    public L118LightGun105mmTowedConfigurationAUS()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 31169, Towed Artillery
        setSubCategory((byte)2); // uid 31171, L118 Light Gun, 105 mm (Towed Configuration) (AUS)
    }
}
