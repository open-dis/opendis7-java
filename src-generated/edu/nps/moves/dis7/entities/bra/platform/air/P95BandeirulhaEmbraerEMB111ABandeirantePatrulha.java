package edu.nps.moves.dis7.entities.bra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@548a9f61;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29152
 */
public class P95BandeirulhaEmbraerEMB111ABandeirantePatrulha extends EntityType
{
    /** Default constructor */
    public P95BandeirulhaEmbraerEMB111ABandeirantePatrulha()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)5); // uid 25696, ASW/Patrol/Observation
        setSubCategory((byte)2); // uid 29152, P-95 Bandeirulha / Embraer EMB 111A Bandeirante Patrulha
    }
}
