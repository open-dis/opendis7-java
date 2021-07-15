package edu.nps.moves.dis7.entities.usa.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@39dda56f;
 * Country: United States of America (USA);
 * Entity kind: Expendable;
 * Domain: SURFACE;
 *
 * Entity type uid: 25000
 */
public class MK58Mod1 extends EntityType
{
    /** Default constructor */
    public MK58Mod1()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 24992, Smoke
        setSubCategory((byte)2); // uid 24993, Smoke Marker
        setSpecific((byte)2); // uid 24998, MK 58 Long Burning Marine Marker
        setExtra((byte)2); // uid 25000, MK 58 Mod 1
    }
}
