package edu.nps.moves.dis7.entities.che.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1a2bcd56
 * Country: Switzerland (CHE)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 19038
 */
public class NORICUMGHN45155mmgunhowitzer extends EntityType
{
    public NORICUMGHN45155mmgunhowitzer()
    {
        setCountry(Country.SWITZERLAND_CHE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)5); // uid 19037, Towed Artillery
        setSubCategory((byte)1); // uid 19038, NORICUM GH N-45 155mm gun-howitzer
    }
}
