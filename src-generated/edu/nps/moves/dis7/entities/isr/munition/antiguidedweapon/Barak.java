package edu.nps.moves.dis7.entities.isr.munition.antiguidedweapon;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4eb9ae4d
 * Country: Israel (ISR)
 * Entity kind: Munition
 * Domain: ANTI_GUIDED_WEAPON
 *
 * Entity type uid: 21293
 */
public class Barak extends EntityType
{
    public Barak()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_GUIDED_WEAPON));

        setCategory((byte)1); // uid 21291, Guided
        setSubCategory((byte)1); // uid 21292, Surface to Air
        setSpecific((byte)1); // uid 21293, Barak
    }
}
