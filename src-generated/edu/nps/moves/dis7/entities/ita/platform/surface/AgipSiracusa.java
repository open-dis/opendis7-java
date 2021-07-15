package edu.nps.moves.dis7.entities.ita.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@339bf286;
 * Country: Italy (ITA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24462
 */
public class AgipSiracusa extends EntityType
{
    /** Default constructor */
    public AgipSiracusa()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24458, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 24459, Crude Oil Tanker (up to 159,999 DWT)
        setSpecific((byte)3); // uid 24462, Agip Siracusa
    }
}
