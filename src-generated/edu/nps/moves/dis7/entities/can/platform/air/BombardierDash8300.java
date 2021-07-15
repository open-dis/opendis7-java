package edu.nps.moves.dis7.entities.can.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@7791a895;
 * Country: Canada (CAN);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24338
 */
public class BombardierDash8300 extends EntityType
{
    /** Default constructor */
    public BombardierDash8300()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)87); // uid 23881, Civilian Fixed Wing Aircraft, Large (up to 255,000 lbs / 115,666 kg)
        setSubCategory((byte)22); // uid 23882, Twin Engine Turboprop
        setSpecific((byte)1); // uid 23883, Bombardier Aerospace DHC-8 Dash 8 Series 300, 400
        setExtra((byte)1); // uid 24338, Bombardier Dash 8-300
    }
}
