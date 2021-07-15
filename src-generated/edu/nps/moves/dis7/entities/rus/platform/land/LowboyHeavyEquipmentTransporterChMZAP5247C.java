package edu.nps.moves.dis7.entities.rus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5467eea4;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 13017
 */
public class LowboyHeavyEquipmentTransporterChMZAP5247C extends EntityType
{
    /** Default constructor */
    public LowboyHeavyEquipmentTransporterChMZAP5247C()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)19); // uid 13015, Heavy equipment transport trailer
        setSubCategory((byte)2); // uid 13017, Lowboy, Heavy Equipment, Transporter, ChMZAP-5247C
    }
}
