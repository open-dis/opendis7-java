package edu.nps.moves.dis7.entities.oth.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@5fa47fea;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29672
 */
public class FlatcarPiggybackwWhiteSemiTrailer extends EntityType
{
    /** Default constructor */
    public FlatcarPiggybackwWhiteSemiTrailer()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)92); // uid 25990, Trains
        setSubCategory((byte)4); // uid 25994, Generic Flatcar
        setSpecific((byte)3); // uid 29670, Flatcar, Piggyback w/ Semi-Trailer
        setExtra((byte)2); // uid 29672, Flatcar, Piggyback w/ White Semi-Trailer
    }
}
