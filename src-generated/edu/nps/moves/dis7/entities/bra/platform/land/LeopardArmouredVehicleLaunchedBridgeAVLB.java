package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@26be92ad
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 32037
 */
public class LeopardArmouredVehicleLaunchedBridgeAVLB extends EntityType
{
    public LeopardArmouredVehicleLaunchedBridgeAVLB()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 32035, Armored Utility Vehicle
        setSubCategory((byte)2); // uid 32037, Leopard Armoured Vehicle-Launched Bridge (AVLB)
    }
}
