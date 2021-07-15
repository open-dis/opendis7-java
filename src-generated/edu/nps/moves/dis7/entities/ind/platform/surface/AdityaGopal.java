package edu.nps.moves.dis7.entities.ind.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@176b3f44;
 * Country: India (IND);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24468
 */
public class AdityaGopal extends EntityType
{
    /** Default constructor */
    public AdityaGopal()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)81); // uid 24463, Dry Cargo Ship (Group 2 Merchant)
        setSubCategory((byte)3); // uid 24464, Container Ship
        setSpecific((byte)4); // uid 24468, Aditya Gopal
    }
}
