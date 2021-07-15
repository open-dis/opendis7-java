package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6edf29c1;
 * Country: United Arab Emirates (ARE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 18689
 */
public class MurayJipLurssen62ClassCorvette extends EntityType
{
    /** Default constructor */
    public MurayJipLurssen62ClassCorvette()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 18688, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 18689, Muray Jip (Lurssen 62) Class (Corvette)
    }
}
