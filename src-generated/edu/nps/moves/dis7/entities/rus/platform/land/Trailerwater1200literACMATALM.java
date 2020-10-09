package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@79a1728c
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 13007
 */
public class Trailerwater1200literACMATALM extends EntityType
{
    public Trailerwater1200literACMATALM()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)17); // uid 13005, Water trailer
        setSubCategory((byte)1); // uid 13006, 1-1000 gallons
        setSpecific((byte)1); // uid 13007, Trailer, water, 1200 liter, ACMAT-ALM
    }
}
