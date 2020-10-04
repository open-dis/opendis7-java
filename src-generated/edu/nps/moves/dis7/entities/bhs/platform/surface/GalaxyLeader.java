package edu.nps.moves.dis7.entities.bhs.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3dd3bcd
 * Country: Bahamas (BHS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31786
 */
public class GalaxyLeader extends EntityType
{
    public GalaxyLeader()
    {
        setCountry(Country.BAHAMAS_BHS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24482, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)5); // uid 31785, Ro-Ro Ship (Roll-on/Roll-off Ship)
        setSpecific((byte)1); // uid 31786, Galaxy Leader
    }
}
