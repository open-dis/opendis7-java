package edu.nps.moves.dis7.entities.usa.radio.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@165aa43a;
 * Country: United States of America (USA);
 * Entity kind: Radio;
 * Domain: AIR;
 *
 * Entity type uid: 27006
 */
public class JointElectronicsTypeDesignationSystemJETDSNonspecificSeries extends EntityType
{
    /** Default constructor */
    public JointElectronicsTypeDesignationSystemJETDSNonspecificSeries()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.RADIO);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)12); // uid 27005, Tactical Air Navigation (TACAN) Transmitter/Receiver (Moving Platform Equipment)
        setSubCategory((byte)1); // uid 27006, Joint Electronics Type Designation System (JETDS) Non-specific Series
    }
}
