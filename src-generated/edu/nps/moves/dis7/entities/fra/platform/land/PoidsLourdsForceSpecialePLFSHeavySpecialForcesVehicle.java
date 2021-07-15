package edu.nps.moves.dis7.entities.fra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@55740540;
 * Country: France (FRA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31115
 */
public class PoidsLourdsForceSpecialePLFSHeavySpecialForcesVehicle extends EntityType
{
    /** Default constructor */
    public PoidsLourdsForceSpecialePLFSHeavySpecialForcesVehicle()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 15674, Small Wheeled Utility Vehicle
        setSubCategory((byte)7); // uid 31113, Sherpa Light Tactial Vehicle
        setSpecific((byte)2); // uid 31115, Poids Lourds Force Speciale (PLFS) - Heavy Special Forces Vehicle
    }
}
