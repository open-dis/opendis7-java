package edu.nps.moves.dis7.entities.syr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@68a4dcc6;
 * Country: Syrian Arab Republic (SYR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 31703
 */
public class _2S1Gvozdika122mmHowitzer extends EntityType
{
    /** Default constructor */
    public _2S1Gvozdika122mmHowitzer()
    {
        setCountry(Country.SYRIAN_ARAB_REPUBLIC_SYR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 31702, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 31703, 2S1 Gvozdika 122-mm Howitzer
    }
}
