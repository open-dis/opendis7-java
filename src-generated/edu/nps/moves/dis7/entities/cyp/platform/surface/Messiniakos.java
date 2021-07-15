package edu.nps.moves.dis7.entities.cyp.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@36bc55de;
 * Country: Cyprus (CYP);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 24507
 */
public class Messiniakos extends EntityType
{
    /** Default constructor */
    public Messiniakos()
    {
        setCountry(Country.ACKNOWLEDGE_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24504, Tanker (Group 3 Merchant)
        setSubCategory((byte)5); // uid 24505, Crude Oil Tanker (up to 159,999 DWT)
        setSpecific((byte)2); // uid 24507, Messiniakos
    }
}
