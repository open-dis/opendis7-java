package edu.nps.moves.dis7.entities.usa.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@669c2b07;
 * Country: United States of America (USA);
 * Entity kind: Expendable;
 * Domain: AIR;
 *
 * Entity type uid: 24980
 */
public class M257IlluminationWarheadPayloadM257IlluminationFlare extends EntityType
{
    /** Default constructor */
    public M257IlluminationWarheadPayloadM257IlluminationFlare()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)7); // uid 24824, Signal/Illumination Flare
        setSubCategory((byte)2); // uid 24825, Illumination Flare
        setSpecific((byte)5); // uid 24979, Hydra 70 w/ M257 Illumination Warhead
        setExtra((byte)1); // uid 24980, M257 Illumination Warhead Payload (M257 Illumination Flare)
    }
}
