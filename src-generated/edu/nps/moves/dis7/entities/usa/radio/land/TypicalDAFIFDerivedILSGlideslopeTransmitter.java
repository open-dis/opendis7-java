package edu.nps.moves.dis7.entities.usa.radio.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@359865a2;
 * Country: United States of America (USA);
 * Entity kind: Radio;
 * Domain: LAND;
 *
 * Entity type uid: 22206
 */
public class TypicalDAFIFDerivedILSGlideslopeTransmitter extends EntityType
{
    /** Default constructor */
    public TypicalDAFIFDerivedILSGlideslopeTransmitter()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 22204, Instrumented Landing System (ILS) Glideslope
        setSubCategory((byte)0); // uid 22205, ILS Glideslope, Other
        setSpecific((byte)3); // uid 22206, Typical DAFIF Derived ILS Glideslope Transmitter
    }
}
