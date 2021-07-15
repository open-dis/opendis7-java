package edu.nps.moves.dis7.entities.usa.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5c573229;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 24976
 */
public class Hydra70wM274SmokeSignatureTrainingWarheadforM151 extends EntityType
{
    /** Default constructor */
    public Hydra70wM274SmokeSignatureTrainingWarheadforM151()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 19971, Ballistic
        setSubCategory((byte)21); // uid 20150, Hydra 70 Rocket System (70 mm, 2.75 in)
        setSpecific((byte)9); // uid 24976, Hydra 70 w/ M274 Smoke Signature Training Warhead (for M151)
    }
}