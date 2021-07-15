package edu.nps.moves.dis7.entities.swe.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4b790d86;
 * Country: Sweden (SWE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26839
 */
public class SkaftoM13 extends EntityType
{
    /** Default constructor */
    public SkaftoM13()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 26832, Mine Countermeasure Ship/Craft
        setSubCategory((byte)2); // uid 26836, Styrso Class
        setSpecific((byte)3); // uid 26839, Skafto (M13)
    }
}