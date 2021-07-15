package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@493ac8d3;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 10064
 */
public class Prototype extends EntityType
{
    /** Default constructor */
    public Prototype()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 10018, Tank
        setSubCategory((byte)9); // uid 10063, AAI Rapid Deployment Force Light Tank (RDF/LT) Combined Arms Team/Lightweight Combat Vehicle (CAT/LCV)
        setSpecific((byte)1); // uid 10064, Prototype
    }
}
