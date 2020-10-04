package edu.nps.moves.dis7.entities.esp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@37e0292a
 * Country: Spain (ESP)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19019
 */
public class TorallaClassCoastalPatrolCraftPC extends EntityType
{
    public TorallaClassCoastalPatrolCraftPC()
    {
        setCountry(Country.SPAIN_ESP);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19011, Light/Patrol Craft
        setSubCategory((byte)5); // uid 19019, Toralla Class (Coastal Patrol Craft) ( PC)
    }
}
