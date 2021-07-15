package edu.nps.moves.dis7.entities.csk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1b7cc17c;
 * Country: Czechoslovakia (CSK);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22830
 */
public class TatraT8158x8SPHowitzer extends EntityType
{
    /** Default constructor */
    public TatraT8158x8SPHowitzer()
    {
        setCountry(Country.ACTION_REQUEST_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 22829, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 22830, Tatra T815 8x8 SP Howitzer
    }
}
