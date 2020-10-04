package edu.nps.moves.dis7.entities.fin.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@68e5eea7
 * Country: Finland (FIN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 28813
 */
public class AMVHeavyWeapon extends EntityType
{
    public AMVHeavyWeapon()
    {
        setCountry(Country.FINLAND_FIN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 28809, Armored Fighting Vehicle
        setSubCategory((byte)2); // uid 28810, Patria AMV
        setSpecific((byte)3); // uid 28813, AMV Heavy Weapon
    }
}
