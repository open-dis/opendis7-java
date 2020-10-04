package edu.nps.moves.dis7.entities.are.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@15c4af7a
 * Country: United Arab Emirates (ARE)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 32008
 */
public class BombardierDash8300MPA extends EntityType
{
    public BombardierDash8300MPA()
    {
        setCountry(Country.UNITED_ARAB_EMIRATES_ARE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 32007, ASW/Patrol/Observation
        setSubCategory((byte)1); // uid 32008, Bombardier Dash 8 300 MPA
    }
}
