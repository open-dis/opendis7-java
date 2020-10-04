package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@38548b19
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23498
 */
public class OdaZ935TrailerVan135Ton extends EntityType
{
    public OdaZ935TrailerVan135Ton()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)14); // uid 12987, Cargo Trailer
        setSubCategory((byte)5); // uid 12995, greater than 10 tons
        setSpecific((byte)2); // uid 23498, OdaZ-935, Trailer, Van, 13.5 Ton
    }
}
