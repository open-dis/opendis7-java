package edu.nps.moves.dis7.entities.can.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3e57cd70
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 30935
 */
public class OffshoreFisheryScienceVessel extends EntityType
{
    public OffshoreFisheryScienceVessel()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)62); // uid 26269, Coast Guard Cutters
        setSubCategory((byte)7); // uid 30935, Offshore Fishery Science Vessel
    }
}
