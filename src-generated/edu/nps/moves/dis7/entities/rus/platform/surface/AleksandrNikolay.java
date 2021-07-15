package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@26d820eb;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 13756
 */
public class AleksandrNikolay extends EntityType
{
    /** Default constructor */
    public AleksandrNikolay()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)9); // uid 13753, Dock landing ship
        setSubCategory((byte)1); // uid 13754, Ivan Rogov Class
        setSpecific((byte)2); // uid 13756, Aleksandr Nikolay
    }
}
