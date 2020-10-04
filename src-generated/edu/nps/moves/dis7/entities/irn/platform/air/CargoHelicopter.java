package edu.nps.moves.dis7.entities.irn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@48d5f34e
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 29879
 */
public class CargoHelicopter extends EntityType
{
    public CargoHelicopter()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)23); // uid 29879, Cargo Helicopter
    }
}
