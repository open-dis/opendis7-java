package edu.nps.moves.dis7.entities.bra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3159c4b8
 * Country: Brazil (BRA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31883
 */
public class ZumbidosPalmaresCrudeOilTanker extends EntityType
{
    public ZumbidosPalmaresCrudeOilTanker()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 31789, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 31878, Crude Oil Tanker (up to 159,999 DWT)
        setSpecific((byte)2); // uid 31883, Zumbi dos Palmares (Crude Oil Tanker)
    }
}
