package edu.nps.moves.dis7.entities.isr.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4e858e0a
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 30287
 */
public class IAIG550ShavitSEMASpecialElectronicMissionsAircraft extends EntityType
{
    public IAIG550ShavitSEMASpecialElectronicMissionsAircraft()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)8); // uid 18191, Surveillance/C2 (Airborne Early Warning)
        setSubCategory((byte)5); // uid 29164, Gulfstream Aerospace - Gulfstream G550
        setSpecific((byte)2); // uid 30287, IAI G550 Shavit SEMA (Special Electronic Missions Aircraft)
    }
}
