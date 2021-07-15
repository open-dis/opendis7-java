package edu.nps.moves.dis7.entities.isr.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@646d810b;
 * Country: Israel (ISR);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 32530
 */
public class DelilahAirLaunched extends EntityType
{
    /** Default constructor */
    public DelilahAirLaunched()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 29011, Guided
        setSubCategory((byte)10); // uid 32530, Delilah (Air Launched)
    }
}
