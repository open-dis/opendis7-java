package edu.nps.moves.dis7.entities.irn.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@33e3bd2e
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Munition
 * Domain: ANTI_SUBMARINE
 *
 * Entity type uid: 30580
 */
public class Hoot extends EntityType
{
    public Hoot()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)1); // uid 30578, Guided
        setSubCategory((byte)1); // uid 30579, 533-mm Torpedo
        setSpecific((byte)1); // uid 30580, Hoot
    }
}
