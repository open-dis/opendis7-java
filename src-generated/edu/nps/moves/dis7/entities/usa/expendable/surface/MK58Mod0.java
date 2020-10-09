package edu.nps.moves.dis7.entities.usa.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@6fc0e448
 * Country: United States of America (USA)
 * Entity kind: Expendable
 * Domain: SURFACE
 *
 * Entity type uid: 24999
 */
public class MK58Mod0 extends EntityType
{
    public MK58Mod0()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 24992, Smoke
        setSubCategory((byte)2); // uid 24993, Smoke Marker
        setSpecific((byte)2); // uid 24998, MK 58 Long Burning Marine Marker
        setExtra((byte)1); // uid 24999, MK 58 Mod 0
    }
}
