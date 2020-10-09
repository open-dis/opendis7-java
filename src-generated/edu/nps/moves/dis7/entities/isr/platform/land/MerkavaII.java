package edu.nps.moves.dis7.entities.isr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5b529706
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23503
 */
public class MerkavaII extends EntityType
{
    public MerkavaII()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 23500, Tank
        setSubCategory((byte)1); // uid 23501, Merkava
        setSpecific((byte)2); // uid 23503, Merkava II
    }
}
