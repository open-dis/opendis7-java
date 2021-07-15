package edu.nps.moves.dis7.entities.can.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5025a98f;
 * Country: Canada (CAN);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31191
 */
public class BisonAmbulance extends EntityType
{
    /** Default constructor */
    public BisonAmbulance()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)3); // uid 31189, Armored Utility Vehicle
        setSubCategory((byte)1); // uid 31190, Bison 8x8 Utility Class
        setSpecific((byte)1); // uid 31191, Bison Ambulance
    }
}
