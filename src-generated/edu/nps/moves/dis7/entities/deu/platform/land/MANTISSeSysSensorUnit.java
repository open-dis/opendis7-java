package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2eea88a1;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 28082
 */
public class MANTISSeSysSensorUnit extends EntityType
{
    /** Default constructor */
    public MANTISSeSysSensorUnit()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 16321, Air Defense/Missile Defense Unit Equipment
        setSubCategory((byte)5); // uid 28080, Modular, Automatic and Network Capable Targeting and Interception System (MANTIS) / NBS-C-RAM
        setSpecific((byte)2); // uid 28082, MANTIS SeSys (Sensor Unit)
    }
}
