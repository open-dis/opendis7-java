package edu.nps.moves.dis7.entities.usa.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@30a9e3db;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: SUBSURFACE;
 *
 * Entity type uid: 28696
 */
public class ANSQQ89AV15MultiFunctionTowedArray extends EntityType
{
    /** Default constructor */
    public ANSQQ89AV15MultiFunctionTowedArray()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)8); // uid 28694, Unmanned Underwater Vehicle (UUV)
        setSubCategory((byte)2); // uid 28695, Remotely Operated Vehicle (ROV)
        setSpecific((byte)1); // uid 28696, AN/SQQ-89 A(V)15 Multi-Function Towed Array
    }
}
