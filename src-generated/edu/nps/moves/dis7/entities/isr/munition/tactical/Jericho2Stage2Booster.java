package edu.nps.moves.dis7.entities.isr.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4faf1f4
 * Country: Israel (ISR)
 * Entity kind: Munition
 * Domain: TACTICAL
 *
 * Entity type uid: 32529
 */
public class Jericho2Stage2Booster extends EntityType
{
    public Jericho2Stage2Booster()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 29011, Guided
        setSubCategory((byte)3); // uid 32525, Jericho 2
        setSpecific((byte)4); // uid 32529, Jericho 2 Stage 2 Booster
    }
}
