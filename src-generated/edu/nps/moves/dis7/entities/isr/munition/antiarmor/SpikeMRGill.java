package edu.nps.moves.dis7.entities.isr.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4c4c7d6c;
 * Country: Israel (ISR);
 * Entity kind: Munition;
 * Domain: ANTI_ARMOR;
 *
 * Entity type uid: 23946
 */
public class SpikeMRGill extends EntityType
{
    /** Default constructor */
    public SpikeMRGill()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)1); // uid 21287, Guided
        setSubCategory((byte)3); // uid 23945, Spike ATGM
        setSpecific((byte)1); // uid 23946, Spike-MR (Gill)
    }
}
