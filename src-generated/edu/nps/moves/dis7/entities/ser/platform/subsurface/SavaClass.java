package edu.nps.moves.dis7.entities.ser.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7cea0110
 * Country: Serbia and Montenegro
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 19088
 */
public class SavaClass extends EntityType
{
    public SavaClass()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 19086, SS (Conventional Attack-Torpedo, Patrol)
        setSubCategory((byte)2); // uid 19088, Sava Class
    }
}
