package edu.nps.moves.dis7.entities.can.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1c58d7be
 * Country: Canada (CAN)
 * Entity kind: Expendable
 * Domain: AIR
 *
 * Entity type uid: 31918
 */
public class Bundle360lb extends EntityType
{
    public Bundle360lb()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 31913, Chaff
        setSubCategory((byte)1); // uid 31914, Bundle
        setSpecific((byte)4); // uid 31918, Bundle 360lb
    }
}
