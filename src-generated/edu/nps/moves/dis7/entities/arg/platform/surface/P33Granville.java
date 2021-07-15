package edu.nps.moves.dis7.entities.arg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1b4fb997;
 * Country: Argentina (ARG);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31261
 */
public class P33Granville extends EntityType
{
    /** Default constructor */
    public P33Granville()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 31257, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 31258, Drummond Class (A-69)
        setSpecific((byte)3); // uid 31261, P 33 Granville
    }
}
