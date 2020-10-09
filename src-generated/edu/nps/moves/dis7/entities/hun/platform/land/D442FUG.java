package edu.nps.moves.dis7.entities.hun.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7776ab
 * Country: Hungary (HUN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23531
 */
public class D442FUG extends EntityType
{
    public D442FUG()
    {
        setCountry(Country.HUNGARY_HUN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 23530, Armored Fighting Vehicle - (IFV, APC, SP mortars, armored cars, chemical reconnaissance, Anti-Tank guided missile launchers, etc.)
        setSubCategory((byte)1); // uid 23531, D-442 FUG
    }
}
