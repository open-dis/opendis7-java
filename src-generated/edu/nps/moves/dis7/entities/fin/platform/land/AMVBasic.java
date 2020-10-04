package edu.nps.moves.dis7.entities.fin.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@38e79ae3
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 28811
 */
public class AMVBasic extends EntityType
{
    public AMVBasic()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 28809, Armored Fighting Vehicle
        setSubCategory((byte)2); // uid 28810, Patria AMV
        setSpecific((byte)1); // uid 28811, AMV Basic
    }
}
