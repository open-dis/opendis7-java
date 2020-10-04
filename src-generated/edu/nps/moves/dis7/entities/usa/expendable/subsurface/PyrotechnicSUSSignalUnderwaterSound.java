package edu.nps.moves.dis7.entities.usa.expendable.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4ec427
 * Country: United States of America (USA)
 * Entity kind: Expendable
 * Domain: SUBSURFACE
 *
 * Entity type uid: 25002
 */
public class PyrotechnicSUSSignalUnderwaterSound extends EntityType
{
    public PyrotechnicSUSSignalUnderwaterSound()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)7); // uid 25001, Signal
        setSubCategory((byte)1); // uid 25002, Pyrotechnic SUS (Signal Underwater Sound)
    }
}
