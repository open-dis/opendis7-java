package edu.nps.moves.dis7.entities.bra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@17c0274c;
 * Country: Brazil (BRA);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 28959
 */
public class MAA1APiranha extends EntityType
{
    /** Default constructor */
    public MAA1APiranha()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 28957, Guided
        setSubCategory((byte)1); // uid 28958, MAA-1 Piranha
        setSpecific((byte)1); // uid 28959, MAA-1A Piranha
    }
}
