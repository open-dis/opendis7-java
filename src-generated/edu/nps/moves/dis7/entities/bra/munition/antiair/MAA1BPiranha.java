package edu.nps.moves.dis7.entities.bra.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7abeabe9;
 * Country: Brazil (BRA);
 * Entity kind: Munition;
 * Domain: ANTI_AIR;
 *
 * Entity type uid: 28960
 */
public class MAA1BPiranha extends EntityType
{
    /** Default constructor */
    public MAA1BPiranha()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 28957, Guided
        setSubCategory((byte)1); // uid 28958, MAA-1 Piranha
        setSpecific((byte)2); // uid 28960, MAA-1B Piranha
    }
}
