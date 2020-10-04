package edu.nps.moves.dis7.entities.mys.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@466cf502
 * Country: Malaysia (MYS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27462
 */
public class F137LaksamanaTanPusmah extends EntityType
{
    public F137LaksamanaTanPusmah()
    {
        setCountry(Country.MALAYSIA_MYS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27457, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 27458, Laksamana Class
        setSpecific((byte)4); // uid 27462, F137 Laksamana Tan Pusmah
    }
}
