package edu.nps.moves.dis7.entities.pan.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3ae66c85;
 * Country: Panama (PAN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24564
 */
public class BergeElbrus extends EntityType
{
    /** Default constructor */
    public BergeElbrus()
    {
        setCountry(Country.PANAMA_PAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24545, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)2); // uid 24546, Dry Bulk Cargo Ship
        setSpecific((byte)4); // uid 24564, Berge Elbrus
    }
}
