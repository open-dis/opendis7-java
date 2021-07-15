package edu.nps.moves.dis7.entities.svk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@636bbbbb;
 * Country: Slovakia (SVK);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 30125
 */
public class RM70Modular extends EntityType
{
    /** Default constructor */
    public RM70Modular()
    {
        setCountry(Country.SLOVAKIA_SVK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 30121, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 30122, RM-70
        setSpecific((byte)3); // uid 30125, RM-70 Modular
    }
}
