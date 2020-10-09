package edu.nps.moves.dis7.entities.ita.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4b3a45f1
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 18283
 */
public class VCC12 extends EntityType
{
    public VCC12()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 18281, Armored Fighting Vehicle
        setSubCategory((byte)1); // uid 18282, Armored Personnel Carrier (APC)
        setSpecific((byte)1); // uid 18283, VCC 1/2
    }
}
