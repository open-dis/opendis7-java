package edu.nps.moves.dis7.entities.usa.radio.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@38667005;
 * Country: United States of America (USA);
 * Entity kind: Radio;
 * Domain: AIR;
 *
 * Entity type uid: 26803
 */
public class ANUSQ140V5CMOSMIDSTerminalNoTACANTACANRT1841CU extends EntityType
{
    /** Default constructor */
    public ANUSQ140V5CMOSMIDSTerminalNoTACANTACANRT1841CU()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)21); // uid 26798, Link 16 Terminal
        setSubCategory((byte)1); // uid 26799, Joint Electronics Type Designation System (JETDS) Non-specific Series
        setSpecific((byte)15); // uid 26803, AN/USQ-140(V)5(C) MOS MIDS Terminal, No TACAN TACAN (RT-1841(C)/U)
    }
}
