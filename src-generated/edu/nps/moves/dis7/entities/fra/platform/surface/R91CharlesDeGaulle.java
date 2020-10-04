package edu.nps.moves.dis7.entities.fra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5b1669c0
 * Country: France (FRA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 15925
 */
public class R91CharlesDeGaulle extends EntityType
{
    public R91CharlesDeGaulle()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)1); // uid 15923, Carrier (Porte-Avions)
        setSubCategory((byte)1); // uid 15924, Nuclear-Propelled Aircraft Carriers (CVN)
        setSpecific((byte)1); // uid 15925, R 91 Charles De Gaulle
    }
}
