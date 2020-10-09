package edu.nps.moves.dis7.entities.isr.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@54ccb3
 * Country: Israel (ISR)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 23947
 */
public class SpikeLR extends EntityType
{
    public SpikeLR()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)1); // uid 21287, Guided
        setSubCategory((byte)3); // uid 23945, Spike ATGM
        setSpecific((byte)2); // uid 23947, Spike-LR
    }
}
