package edu.nps.moves.dis7.entities.usa.radio.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6abe62bb
 * Country: United States of America (USA)
 * Entity kind: Radio
 * Domain: AIR
 *
 * Entity type uid: 27007
 */
public class ANARN118 extends EntityType
{
    public ANARN118()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)12); // uid 27005, Tactical Air Navigation (TACAN) Transmitter/Receiver (Moving Platform Equipment)
        setSubCategory((byte)1); // uid 27006, Joint Electronics Type Designation System (JETDS) Non-specific Series
        setSpecific((byte)1); // uid 27007, AN/ARN-118
    }
}
