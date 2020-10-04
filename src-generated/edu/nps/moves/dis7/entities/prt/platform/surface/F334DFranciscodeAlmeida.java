package edu.nps.moves.dis7.entities.prt.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@54534abf
 * Country: Portugal (PRT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23097
 */
public class F334DFranciscodeAlmeida extends EntityType
{
    public F334DFranciscodeAlmeida()
    {
        setCountry(Country.PORTUGAL_PRT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 23090, Guided Missile Frigate (FFG)
        setSubCategory((byte)2); // uid 23095, Karel Doorman Class
        setSpecific((byte)2); // uid 23097, F334 D. Francisco de Almeida
    }
}
