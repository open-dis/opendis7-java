package edu.nps.moves.dis7.entities.isr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@b70da4c;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 18242
 */
public class Iquique extends EntityType
{
    /** Default constructor */
    public Iquique()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18214, Light/Patrol Craft
        setSubCategory((byte)7); // uid 18241, Iquique (Saar3)
        setSpecific((byte)1); // uid 18242, Iquique
    }
}