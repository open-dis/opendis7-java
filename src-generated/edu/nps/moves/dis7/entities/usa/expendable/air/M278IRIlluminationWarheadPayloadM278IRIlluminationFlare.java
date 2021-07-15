package edu.nps.moves.dis7.entities.usa.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@6a902015;
 * Country: United States of America (USA);
 * Entity kind: Expendable;
 * Domain: AIR;
 *
 * Entity type uid: 24982
 */
public class M278IRIlluminationWarheadPayloadM278IRIlluminationFlare extends EntityType
{
    /** Default constructor */
    public M278IRIlluminationWarheadPayloadM278IRIlluminationFlare()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)7); // uid 24824, Signal/Illumination Flare
        setSubCategory((byte)2); // uid 24825, Illumination Flare
        setSpecific((byte)6); // uid 24981, Hydra 70 w/ M278 IR Illumination Warhead
        setExtra((byte)1); // uid 24982, M278 IR Illumination Warhead Payload (M278 IR Illumination Flare)
    }
}
