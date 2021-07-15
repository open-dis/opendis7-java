package edu.nps.moves.dis7.entities.ser.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3a175162;
 * Country: Serbia and Montenegro;
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23669
 */
public class BOV1PoloM83wAT3ATGM extends EntityType
{
    /** Default constructor */
    public BOV1PoloM83wAT3ATGM()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 23663, Armored Fighting Vehicle - (IFV, APC, SP mortars, armored cars, chemical reconnaissance, Anti-Tank guided missile launchers, etc.)
        setSubCategory((byte)3); // uid 23668, BOV APC
        setSpecific((byte)1); // uid 23669, BOV-1 Polo M-83 w/ AT-3 ATGM
    }
}
