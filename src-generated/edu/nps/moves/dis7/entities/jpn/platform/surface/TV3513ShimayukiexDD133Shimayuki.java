package edu.nps.moves.dis7.entities.jpn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@eb6449b
 * Country: Japan (JPN)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 26265
 */
public class TV3513ShimayukiexDD133Shimayuki extends EntityType
{
    public TV3513ShimayukiexDD133Shimayuki()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)5); // uid 18890, Destroyer (DD)
        setSubCategory((byte)4); // uid 18894, Hatsuyuki Class (DD)
        setSpecific((byte)12); // uid 26265, TV-3513 Shimayuki (ex-DD-133 Shimayuki)
    }
}
