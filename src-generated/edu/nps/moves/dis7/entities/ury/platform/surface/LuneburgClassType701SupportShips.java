package edu.nps.moves.dis7.entities.ury.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@29962b2f;
 * Country: Uruguay (URY);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27491
 */
public class LuneburgClassType701SupportShips extends EntityType
{
    /** Default constructor */
    public LuneburgClassType701SupportShips()
    {
        setCountry(Country.URUGUAY_URY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27490, Auxiliary
        setSubCategory((byte)1); // uid 27491, Luneburg Class (Type 701, Support Ships)
    }
}
