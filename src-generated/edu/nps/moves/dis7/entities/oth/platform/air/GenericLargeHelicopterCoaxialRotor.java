package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@437ebf59
 * Country: Other
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 24733
 */
public class GenericLargeHelicopterCoaxialRotor extends EntityType
{
    public GenericLargeHelicopterCoaxialRotor()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)92); // uid 24729, Civilian Helicopter, Large (above 20,000 lbs / 9,072 kg)
        setSubCategory((byte)22); // uid 24733, Generic Large Helicopter, Coaxial Rotor
    }
}
