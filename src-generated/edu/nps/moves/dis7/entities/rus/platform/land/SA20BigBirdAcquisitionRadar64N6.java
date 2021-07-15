package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@460b6d54;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 13150
 */
public class SA20BigBirdAcquisitionRadar64N6 extends EntityType
{
    /** Default constructor */
    public SA20BigBirdAcquisitionRadar64N6()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 13034, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)21); // uid 13145, SA-20 Gargoyle SAM System
        setSpecific((byte)5); // uid 13150, SA-20 Big Bird Acquisition Radar (64N6)
    }
}
