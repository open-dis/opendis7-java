package edu.nps.moves.dis7.entities.zaf.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1a0b5323;
 * Country: South Africa (ZAF);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 19104
 */
public class G6155mmHowitzer extends EntityType
{
    /** Default constructor */
    public G6155mmHowitzer()
    {
        setCountry(Country.SOUTH_AFRICA_ZAF);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 19103, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 19104, G6 155-mm Howitzer
    }
}
