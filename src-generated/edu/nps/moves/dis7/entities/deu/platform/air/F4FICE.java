package edu.nps.moves.dis7.entities.deu.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@72d6b3ba;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28046
 */
public class F4FICE extends EntityType
{
    /** Default constructor */
    public F4FICE()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 16328, Fighter/Air Defense
        setSubCategory((byte)5); // uid 28044, McDonnell-Douglas F-4 Phantom II
        setSpecific((byte)2); // uid 28046, F-4F ICE
    }
}
