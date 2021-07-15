package edu.nps.moves.dis7.entities.mar.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@452e26d0;
 * Country: Morocco (MAR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28870
 */
public class _613TarikBenZiyad extends EntityType
{
    /** Default constructor */
    public _613TarikBenZiyad()
    {
        setCountry(Country.MOROCCO_MAR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 28865, Frigate (including Corvette)
        setSubCategory((byte)2); // uid 28869, Sigma 10513 Class
        setSpecific((byte)1); // uid 28870, 613 Tarik Ben Ziyad
    }
}
