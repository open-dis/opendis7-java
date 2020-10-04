package edu.nps.moves.dis7.entities.bhr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3c09711b
 * Country: Bahrain (BHR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18668
 */
public class _50ALManama extends EntityType
{
    public _50ALManama()
    {
        setCountry(Country.BAHRAIN_BHR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18666, Light/Patrol Craft
        setSubCategory((byte)1); // uid 18667, AL Manama (FPB 62) Class (fast attack craft-missile)
        setSpecific((byte)1); // uid 18668, 50 AL Manama
    }
}
