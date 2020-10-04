package edu.nps.moves.dis7.entities.usa.expendable.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7c0e4e4e
 * Country: United States of America (USA)
 * Entity kind: Expendable
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22279
 */
public class CMADCMK4BBN extends EntityType
{
    public CMADCMK4BBN()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)4); // uid 22272, Active Emitter
        setSubCategory((byte)5); // uid 22277, CM ADC MK 4
        setSpecific((byte)2); // uid 22279, CM ADC MK 4 BBN
    }
}
