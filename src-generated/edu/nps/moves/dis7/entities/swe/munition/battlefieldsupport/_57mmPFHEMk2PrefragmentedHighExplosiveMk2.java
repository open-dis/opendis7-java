package edu.nps.moves.dis7.entities.swe.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5d767218;
 * Country: Sweden (SWE);
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 27455
 */
public class _57mmPFHEMk2PrefragmentedHighExplosiveMk2 extends EntityType
{
    /** Default constructor */
    public _57mmPFHEMk2PrefragmentedHighExplosiveMk2()
    {
        setCountry(Country.SWEDEN_SWE);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 21657, Ballistic
        setSubCategory((byte)3); // uid 27452, 57 mm
        setSpecific((byte)3); // uid 27455, 57 mm PFHE Mk2 (Prefragmented High Explosive Mk 2)
    }
}
