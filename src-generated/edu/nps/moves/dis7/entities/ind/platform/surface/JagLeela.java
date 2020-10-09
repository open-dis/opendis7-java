package edu.nps.moves.dis7.entities.ind.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4879dfad
 * Country: India (IND)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 24476
 */
public class JagLeela extends EntityType
{
    public JagLeela()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24472, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 24473, Crude Oil Tanker (up to 159,999 DWT)
        setSpecific((byte)3); // uid 24476, Jag Leela
    }
}
