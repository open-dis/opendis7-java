package edu.nps.moves.dis7.entities.ltu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7cc586a8;
 * Country: Lithuania (LTU);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27784
 */
public class N42Jotvingis extends EntityType
{
    /** Default constructor */
    public N42Jotvingis()
    {
        setCountry(Country.LITHUANIA_LTU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 27782, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 27783, Vidar Class
        setSpecific((byte)1); // uid 27784, N42 Jotvingis
    }
}
