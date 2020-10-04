package edu.nps.moves.dis7.entities.can.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@27a8c74e
 * Country: Canada (CAN)
 * Entity kind: Platform
 * Domain: AIR
 *
 * Entity type uid: 32116
 */
public class AW139STARSAirAmbulance extends EntityType
{
    public AW139STARSAirAmbulance()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)91); // uid 32113, Civilian Helicopter, Medium (up to 20,000 lbs / 9,072 kg)
        setSubCategory((byte)12); // uid 32114, Single Rotor, Turboshaft Engine, Conventional Tail Rotor
        setSpecific((byte)1); // uid 32115, Leonardo (AgustaWestland) AW139
        setExtra((byte)1); // uid 32116, AW139 STARS Air Ambulance
    }
}
