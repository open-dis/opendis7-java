package edu.nps.moves.dis7.entities.isr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@66b7550d
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27541
 */
public class BatGalim extends EntityType
{
    public BatGalim()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)18); // uid 27538, Utility
        setSubCategory((byte)1); // uid 27539, Stollergrund Class (Type 745)
        setSpecific((byte)2); // uid 27541, Bat Galim
    }
}
