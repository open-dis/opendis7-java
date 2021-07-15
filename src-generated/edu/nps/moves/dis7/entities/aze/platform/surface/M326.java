package edu.nps.moves.dis7.entities.aze.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1554909b;
 * Country: Azerbaijan (AZE);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 29961
 */
public class M326 extends EntityType
{
    /** Default constructor */
    public M326()
    {
        setCountry(Country.AZERBAIJAN_AZE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 29958, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 29959, Sonya Class
        setSpecific((byte)2); // uid 29961, M326
    }
}
