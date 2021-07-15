package edu.nps.moves.dis7.entities.pak.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4aa3d36;
 * Country: Pakistan (PAK);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24809
 */
public class Saab2000AEWC extends EntityType
{
    /** Default constructor */
    public Saab2000AEWC()
    {
        setCountry(Country.PAKISTAN_PAK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 24808, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)1); // uid 24809, Saab 2000 AEW&C
    }
}
