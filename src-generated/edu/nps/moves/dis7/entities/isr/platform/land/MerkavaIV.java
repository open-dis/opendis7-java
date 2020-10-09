package edu.nps.moves.dis7.entities.isr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7b5a12ae
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 23505
 */
public class MerkavaIV extends EntityType
{
    public MerkavaIV()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 23500, Tank
        setSubCategory((byte)1); // uid 23501, Merkava
        setSpecific((byte)4); // uid 23505, Merkava IV
    }
}
