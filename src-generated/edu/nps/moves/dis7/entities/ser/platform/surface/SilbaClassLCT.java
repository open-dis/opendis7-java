package edu.nps.moves.dis7.entities.ser.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2b037cfc;
 * Country: Serbia and Montenegro;
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 19082
 */
public class SilbaClassLCT extends EntityType
{
    /** Default constructor */
    public SilbaClassLCT()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 19081, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 19082, Silba Class (LCT)
    }
}
