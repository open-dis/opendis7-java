package edu.nps.moves.dis7.entities.csk.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6b2ea799
 * Country: Czechoslovakia (CSK)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 19130
 */
public class AeroL29Delfin extends EntityType
{
    public AeroL29Delfin()
    {
        setCountry(Country.CZECHOSLOVAKIA_CSK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 19128, Trainer
        setSubCategory((byte)2); // uid 19130, Aero L-29 Delfin
    }
}
