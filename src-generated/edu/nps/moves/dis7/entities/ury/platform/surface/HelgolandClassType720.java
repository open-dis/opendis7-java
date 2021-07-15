package edu.nps.moves.dis7.entities.ury.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@43a4a9e5;
 * Country: Uruguay (URY);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27533
 */
public class HelgolandClassType720 extends EntityType
{
    /** Default constructor */
    public HelgolandClassType720()
    {
        setCountry(Country.URUGUAY_URY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27490, Auxiliary
        setSubCategory((byte)3); // uid 27533, Helgoland Class (Type 720)
    }
}
