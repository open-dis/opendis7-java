package edu.nps.moves.dis7.entities.sgp.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@50756c76
 * Country: Singapore (SGP)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 25554
 */
public class BionixII extends EntityType
{
    public BionixII()
    {
        setCountry(Country.SINGAPORE_SGP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 25549, Armored Fighting Vehicle
        setSubCategory((byte)2); // uid 25551, Bionix AFV
        setSpecific((byte)3); // uid 25554, Bionix II
    }
}
