package edu.nps.moves.dis7.entities.aus.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3339ad8e;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 26268
 */
public class E7AWedgetail extends EntityType
{
    /** Default constructor */
    public E7AWedgetail()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 26266, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)1); // uid 26267, Boeing 737-7ES AEW&C
        setSpecific((byte)1); // uid 26268, E-7A Wedgetail
    }
}
