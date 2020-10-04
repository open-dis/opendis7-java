package edu.nps.moves.dis7.entities.usa.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@65d90b7f
 * Country: United States of America (USA)
 * Entity kind: Expendable
 * Domain: SURFACE
 *
 * Entity type uid: 24997
 */
public class MK25Mod4 extends EntityType
{
    public MK25Mod4()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 24992, Smoke
        setSubCategory((byte)2); // uid 24993, Smoke Marker
        setSpecific((byte)1); // uid 24994, MK 25 Short Burning Marine Marker
        setExtra((byte)4); // uid 24997, MK 25 Mod 4
    }
}
