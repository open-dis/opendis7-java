package edu.nps.moves.dis7.entities.alb.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@25f38edc;
 * Country: Albania (ALB);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24479
 */
public class DryCargoShipGroup2Merchant extends EntityType
{
    /** Default constructor */
    public DryCargoShipGroup2Merchant()
    {
        setCountry(Country.ALBANIA_ALB);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24479, Dry Cargo Ship (Group 2 Merchant)
    }
}
