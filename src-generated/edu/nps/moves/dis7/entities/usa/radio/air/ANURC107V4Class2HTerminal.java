package edu.nps.moves.dis7.entities.usa.radio.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@61c4cebd
 * Country: United States of America (USA)
 * Entity kind: Radio
 * Domain: AIR
 *
 * Entity type uid: 26814
 */
public class ANURC107V4Class2HTerminal extends EntityType
{
    public ANURC107V4Class2HTerminal()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 26798, Link 16 Terminal
        setSubCategory((byte)1); // uid 26799, Joint Electronics Type Designation System (JETDS) Non-specific Series
        setSpecific((byte)44); // uid 26814, AN/URC-107(V)4 Class 2H Terminal
    }
}
