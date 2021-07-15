package edu.nps.moves.dis7.entities.nor.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@49a64d82;
 * Country: Norway (NOR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27616
 */
public class M352Rauma extends EntityType
{
    /** Default constructor */
    public M352Rauma()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 18974, Mine Countermeasure Ship/Craft
        setSubCategory((byte)2); // uid 27610, Oksoey/Alta class
        setSpecific((byte)6); // uid 27616, M352 Rauma
    }
}
