package edu.nps.moves.dis7.entities.isr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3ecd267f;
 * Country: Israel (ISR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29349
 */
public class HarpyLauncher extends EntityType
{
    /** Default constructor */
    public HarpyLauncher()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 29348, Large Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 29349, Harpy Launcher
    }
}
