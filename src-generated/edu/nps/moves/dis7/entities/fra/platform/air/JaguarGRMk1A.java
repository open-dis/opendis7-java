package edu.nps.moves.dis7.entities.fra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5ba3f27a;
 * Country: France (FRA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 15909
 */
public class JaguarGRMk1A extends EntityType
{
    /** Default constructor */
    public JaguarGRMk1A()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)40); // uid 15904, Trainer
        setSubCategory((byte)4); // uid 15908, SEPECAT Jaguar International
        setSpecific((byte)1); // uid 15909, Jaguar GR. Mk 1A
    }
}
