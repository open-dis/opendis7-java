package edu.nps.moves.dis7.entities.mar.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6815c5f2;
 * Country: Morocco (MAR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27725
 */
public class _404AbouAbdallahElAyachi extends EntityType
{
    /** Default constructor */
    public _404AbouAbdallahElAyachi()
    {
        setCountry(Country.MOROCCO_MAR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 27721, Landing Craft
        setSubCategory((byte)2); // uid 27722, Batral Class
        setSpecific((byte)3); // uid 27725, 404 Abou Abdallah El Ayachi
    }
}
