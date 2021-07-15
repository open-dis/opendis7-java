package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@710b30ef;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24718
 */
public class GenericSmallHelicopterSingleRotorTurboshaftEngineConventionalTailRotor extends EntityType
{
    /** Default constructor */
    public GenericSmallHelicopterSingleRotorTurboshaftEngineConventionalTailRotor()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)90); // uid 24716, Civilian Helicopter, Small (up to 7,000 lbs / 3,175 kg)
        setSubCategory((byte)12); // uid 24718, Generic Small Helicopter, Single Rotor, Turboshaft Engine, Conventional Tail Rotor
    }
}
