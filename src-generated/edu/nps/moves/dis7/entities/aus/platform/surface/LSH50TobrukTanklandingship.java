package edu.nps.moves.dis7.entities.aus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3d24753a
 * Country: Australia (AUS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17584
 */
public class LSH50TobrukTanklandingship extends EntityType
{
    public LSH50TobrukTanklandingship()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 17582, Landing Craft
        setSubCategory((byte)1); // uid 17583, Modified Sir Bedivere Class
        setSpecific((byte)1); // uid 17584, LSH 50 Tobruk Tank landing ship
    }
}
