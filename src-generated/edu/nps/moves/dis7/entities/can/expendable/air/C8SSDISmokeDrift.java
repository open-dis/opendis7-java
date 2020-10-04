package edu.nps.moves.dis7.entities.can.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5b490d5e
 * Country: Canada (CAN)
 * Entity kind: Expendable
 * Domain: AIR
 *
 * Entity type uid: 31946
 */
public class C8SSDISmokeDrift extends EntityType
{
    public C8SSDISmokeDrift()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 31944, Smoke Generator
        setSubCategory((byte)2); // uid 31945, Target/Spot Marker
        setSpecific((byte)1); // uid 31946, C8 SSDI Smoke Drift
    }
}
