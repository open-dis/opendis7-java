package edu.nps.moves.dis7.entities.are.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@43d9f1a2
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18717
 */
public class L5402Jananah extends EntityType
{
    public L5402Jananah()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 18714, Tank Landing Ship
        setSubCategory((byte)1); // uid 18715, LSL/LST
        setSpecific((byte)2); // uid 18717, L5402 Jananah
    }
}
