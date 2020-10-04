package edu.nps.moves.dis7.entities.tur.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2bfb6b49
 * Country: Turkey (TUR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23282
 */
public class NL124Karamurselbey extends EntityType
{
    public NL124Karamurselbey()
    {
        setCountry(Country.TURKEY_TUR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 23276, Tank Landing Ship
        setSubCategory((byte)2); // uid 23280, Sarucabey class
        setSpecific((byte)2); // uid 23282, NL124 Karamurselbey
    }
}
