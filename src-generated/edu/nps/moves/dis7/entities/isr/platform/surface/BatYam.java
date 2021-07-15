package edu.nps.moves.dis7.entities.isr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1c3146bc;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27540
 */
public class BatYam extends EntityType
{
    /** Default constructor */
    public BatYam()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)18); // uid 27538, Utility
        setSubCategory((byte)1); // uid 27539, Stollergrund Class (Type 745)
        setSpecific((byte)1); // uid 27540, Bat Yam
    }
}