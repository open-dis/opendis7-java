package edu.nps.moves.dis7.entities.oth.radio.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@34e25492
 * Country: Other
 * Entity kind: Radio
 * Domain: SURFACE
 *
 * Entity type uid: 31910
 */
public class AutomaticIdentificationSystemAIS extends EntityType
{
    public AutomaticIdentificationSystemAIS()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)37); // uid 31910, Automatic Identification System (AIS)
    }
}
