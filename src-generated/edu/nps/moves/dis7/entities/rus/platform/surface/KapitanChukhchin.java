package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2cfa2c4f;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24411
 */
public class KapitanChukhchin extends EntityType
{
    /** Default constructor */
    public KapitanChukhchin()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24407, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 24408, Container Ship
        setSpecific((byte)3); // uid 24411, Kapitan Chukhchin
    }
}
