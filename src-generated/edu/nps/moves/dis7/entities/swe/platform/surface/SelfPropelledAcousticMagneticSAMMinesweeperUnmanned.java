package edu.nps.moves.dis7.entities.swe.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5ef6fd7f;
 * Country: Sweden (SWE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26842
 */
public class SelfPropelledAcousticMagneticSAMMinesweeperUnmanned extends EntityType
{
    /** Default constructor */
    public SelfPropelledAcousticMagneticSAMMinesweeperUnmanned()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)19); // uid 26841, Unmanned Surface Vehicle (USV)
        setSubCategory((byte)1); // uid 26842, Self-Propelled Acoustic/Magnetic (SAM) Minesweeper (Unmanned)
    }
}
