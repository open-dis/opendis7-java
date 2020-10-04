package edu.nps.moves.dis7.entities.usa.radio.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1dbff71c
 * Country: United States of America (USA)
 * Entity kind: Radio
 * Domain: LAND
 *
 * Entity type uid: 26795
 */
public class ANGSQ240Class2MTerminal extends EntityType
{
    public ANGSQ240Class2MTerminal()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)21); // uid 26793, Link 16 Terminal
        setSubCategory((byte)1); // uid 26794, Joint Electronics Type Designation System (JETDS) Non-specific Series
        setSpecific((byte)1); // uid 26795, AN/GSQ-240 Class 2M Terminal
    }
}
