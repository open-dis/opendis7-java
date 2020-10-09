package edu.nps.moves.dis7.entities.oth.supply.notused;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@b77b0a0
 * Country: Other
 * Entity kind: Supply
 * Domain: NOT_USED
 *
 * Entity type uid: 22165
 */
public class Other extends EntityType
{
    public Other()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.NOT_USED));

        setCategory((byte)0); // uid 22165, Other
    }
}
