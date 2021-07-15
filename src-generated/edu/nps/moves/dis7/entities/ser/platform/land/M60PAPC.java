package edu.nps.moves.dis7.entities.ser.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@10358c32;
 * Country: Serbia and Montenegro;
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23667
 */
public class M60PAPC extends EntityType
{
    /** Default constructor */
    public M60PAPC()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 23663, Armored Fighting Vehicle - (IFV, APC, SP mortars, armored cars, chemical reconnaissance, Anti-Tank guided missile launchers, etc.)
        setSubCategory((byte)2); // uid 23666, M-60 APC
        setSpecific((byte)1); // uid 23667, M-60P APC
    }
}
