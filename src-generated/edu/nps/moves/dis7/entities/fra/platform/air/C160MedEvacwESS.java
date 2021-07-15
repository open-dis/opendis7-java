package edu.nps.moves.dis7.entities.fra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@66498326;
 * Country: France (FRA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28010
 */
public class C160MedEvacwESS extends EntityType
{
    /** Default constructor */
    public C160MedEvacwESS()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 15791, Cargo/Tanker
        setSubCategory((byte)1); // uid 15792, Transall C-160
        setSpecific((byte)2); // uid 28009, C-160 MedEvac
        setExtra((byte)1); // uid 28010, C-160 MedEvac w/ ESS
    }
}
