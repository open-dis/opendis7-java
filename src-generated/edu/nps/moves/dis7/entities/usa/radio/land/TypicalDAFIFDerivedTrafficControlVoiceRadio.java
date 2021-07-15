package edu.nps.moves.dis7.entities.usa.radio.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@389a1e34;
 * Country: United States of America (USA);
 * Entity kind: Radio;
 * Domain: LAND;
 *
 * Entity type uid: 22203
 */
public class TypicalDAFIFDerivedTrafficControlVoiceRadio extends EntityType
{
    /** Default constructor */
    public TypicalDAFIFDerivedTrafficControlVoiceRadio()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 22201, Voice Transmission/Reception
        setSubCategory((byte)0); // uid 22202, Voice Transmission/Reception, Other
        setSpecific((byte)3); // uid 22203, Typical DAFIF Derived Traffic Control Voice Radio
    }
}
