package edu.nps.moves.dis7.entities.ukr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@43f1bb92
 * Country: Ukraine (UKR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27864
 */
public class BG50GrigoryKuropiatnikov extends EntityType
{
    public BG50GrigoryKuropiatnikov()
    {
        setCountry(Country.UKRAINE_UKR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 27862, Light/Patrol Craft
        setSubCategory((byte)1); // uid 27863, Pauk I Class
        setSpecific((byte)1); // uid 27864, BG 50 Grigory Kuropiatnikov
    }
}
