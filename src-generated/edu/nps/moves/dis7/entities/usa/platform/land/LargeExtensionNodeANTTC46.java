package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@168b4cb0;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23473
 */
public class LargeExtensionNodeANTTC46 extends EntityType
{
    /** Default constructor */
    public LargeExtensionNodeANTTC46()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)33); // uid 10746, Communications Facility
        setSubCategory((byte)1); // uid 23472, Mobile Subscriber Equipment (MSE) Platform
        setSpecific((byte)1); // uid 23473, Large Extension Node, AN/TTC-46
    }
}