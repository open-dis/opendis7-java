package edu.nps.moves.dis7.entities.bra.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@27efef64;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 32641
 */
public class G29GarciaDAvila extends EntityType
{
    /** Default constructor */
    public G29GarciaDAvila()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)55); // uid 32638, Amphibious Cargo Ship
        setSubCategory((byte)1); // uid 32639, Round Table Class
        setSpecific((byte)2); // uid 32641, G29 Garcia DAvila
    }
}
