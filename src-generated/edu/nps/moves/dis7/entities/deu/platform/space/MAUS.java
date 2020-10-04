package edu.nps.moves.dis7.entities.deu.platform.space;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@13330ac6
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SPACE
 *
 * Entity type uid: 16848
 */
public class MAUS extends EntityType
{
    public MAUS()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SPACE));

        setCategory((byte)2); // uid 16811, Unmanned
        setSubCategory((byte)15); // uid 16840, Microgravity Satellite
        setSpecific((byte)8); // uid 16848, MAUS
    }
}
