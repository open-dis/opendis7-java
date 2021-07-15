package edu.nps.moves.dis7.entities.bgr.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3b11620a;
 * Country: Bulgaria (BGR);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 28728
 */
public class AHM2002 extends EntityType
{
    /** Default constructor */
    public AHM2002()
    {
        setCountry(Country.BULGARIA_BGR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)3); // uid 28725, Fixed
        setSubCategory((byte)1); // uid 28726, Anti-Helicopter Mine (AHM)
        setSpecific((byte)2); // uid 28728, AHM-200-2
    }
}
