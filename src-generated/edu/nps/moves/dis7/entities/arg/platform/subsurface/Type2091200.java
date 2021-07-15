package edu.nps.moves.dis7.entities.arg.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3d82c5f3;
 * Country: Argentina (ARG);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 32599
 */
public class Type2091200 extends EntityType
{
    /** Default constructor */
    public Type2091200()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18761, SS (Conventional Attack - Torpedo, Patrol
        setSubCategory((byte)2); // uid 32599, Type 209/1200
    }
}
