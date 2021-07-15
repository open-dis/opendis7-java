package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@2d66530f;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31862
 */
public class Ural43203R330ZhJammer extends EntityType
{
    /** Default constructor */
    public Ural43203R330ZhJammer()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 12867, Large Wheeled Utility Vehicle
        setSubCategory((byte)11); // uid 12902, Ural-4320 6x6 4500-kg trucks
        setSpecific((byte)1); // uid 31861, Ural-43203
        setExtra((byte)1); // uid 31862, Ural-43203 R330Zh Jammer
    }
}
