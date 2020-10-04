package edu.nps.moves.dis7.entities.srb.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5c448433
 * Country: Serbia (SRB)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 30169
 */
public class BOV3wM55A4B13x20mm extends EntityType
{
    public BOV3wM55A4B13x20mm()
    {
        setCountry(Country.SERBIA_SRB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)28); // uid 30166, Air Defense / Missile Defense Unit Equipment
        setSubCategory((byte)2); // uid 30168, Self -Propelled VSHORAD Gun / Missile System
        setSpecific((byte)1); // uid 30169, BOV-3 w/ M55A4B1 3 x 20-mm
    }
}
