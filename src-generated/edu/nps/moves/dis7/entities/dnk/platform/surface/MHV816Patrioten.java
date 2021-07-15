package edu.nps.moves.dis7.entities.dnk.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5542c4ed;
 * Country: Denmark (DNK);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 25501
 */
public class MHV816Patrioten extends EntityType
{
    /** Default constructor */
    public MHV816Patrioten()
    {
        setCountry(Country.ACTION_RESPONSE_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)63); // uid 25472, Coast Guard Boats
        setSubCategory((byte)2); // uid 25485, MHV 800 Class
        setSpecific((byte)16); // uid 25501, MHV-816 Patrioten
    }
}