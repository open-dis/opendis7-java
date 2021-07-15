package edu.nps.moves.dis7.entities.cok.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@515aebb0;
 * Country: Cook Islands (COK);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26737
 */
public class TeKukupa extends EntityType
{
    /** Default constructor */
    public TeKukupa()
    {
        setCountry(Country.CREATE_ENTITY_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26735, Light/Patrol Craft
        setSubCategory((byte)1); // uid 26736, Pacific Class Patrol Boat
        setSpecific((byte)1); // uid 26737, Te Kukupa
    }
}
