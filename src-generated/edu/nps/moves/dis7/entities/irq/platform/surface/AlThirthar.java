package edu.nps.moves.dis7.entities.irq.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@52d645b1;
 * Country: Iraq (IRQ);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24582
 */
public class AlThirthar extends EntityType
{
    /** Default constructor */
    public AlThirthar()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24580, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 24581, Crude Oil Tanker (up to 159,999 DWT)
        setSpecific((byte)1); // uid 24582, Al Thirthar
    }
}
