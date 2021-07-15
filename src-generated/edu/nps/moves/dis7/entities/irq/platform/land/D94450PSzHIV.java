package edu.nps.moves.dis7.entities.irq.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@60975100;
 * Country: Iraq (IRQ);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23533
 */
public class D94450PSzHIV extends EntityType
{
    /** Default constructor */
    public D94450PSzHIV()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 17986, Armored Fighting Vehicle
        setSubCategory((byte)4); // uid 23532, D-944 PSzH-IV
        setSpecific((byte)1); // uid 23533, D-944.50 PSzH-IV
    }
}
