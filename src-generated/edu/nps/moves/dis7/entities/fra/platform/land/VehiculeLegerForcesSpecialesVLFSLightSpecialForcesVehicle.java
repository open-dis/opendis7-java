package edu.nps.moves.dis7.entities.fra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@29647f75
 * Country: France (FRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31114
 */
public class VehiculeLegerForcesSpecialesVLFSLightSpecialForcesVehicle extends EntityType
{
    public VehiculeLegerForcesSpecialesVLFSLightSpecialForcesVehicle()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 15674, Small Wheeled Utility Vehicle
        setSubCategory((byte)7); // uid 31113, Sherpa Light Tactial Vehicle
        setSpecific((byte)1); // uid 31114, Vehicule Leger Forces Speciales (VLFS) - Light Special Forces Vehicle
    }
}
