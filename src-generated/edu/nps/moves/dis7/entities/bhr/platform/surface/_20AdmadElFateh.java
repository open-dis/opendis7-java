package edu.nps.moves.dis7.entities.bhr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4590c9c3
 * Country: Bahrain (BHR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18671
 */
public class _20AdmadElFateh extends EntityType
{
    public _20AdmadElFateh()
    {
        setCountry(Country.BAHRAIN_BHR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18666, Light/Patrol Craft
        setSubCategory((byte)2); // uid 18670, Almad EL Fateh (FPB 45) Class (fast attack craft-missile)
        setSpecific((byte)1); // uid 18671, 20 Admad El Fateh
    }
}
