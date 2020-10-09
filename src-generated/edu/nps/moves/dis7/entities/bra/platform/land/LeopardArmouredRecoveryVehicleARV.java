package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4c70fda8
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 32038
 */
public class LeopardArmouredRecoveryVehicleARV extends EntityType
{
    public LeopardArmouredRecoveryVehicleARV()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 32035, Armored Utility Vehicle
        setSubCategory((byte)3); // uid 32038, Leopard Armoured Recovery Vehicle (ARV)
    }
}
