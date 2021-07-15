package edu.nps.moves.dis7.entities.fin.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6913c1fb;
 * Country: Finland (FIN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28534
 */
public class Hawk51A extends EntityType
{
    /** Default constructor */
    public Hawk51A()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 28531, Trainer
        setSubCategory((byte)1); // uid 28532, BAE Systems Hawk
        setSpecific((byte)2); // uid 28534, Hawk 51A
    }
}
