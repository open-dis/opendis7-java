package edu.nps.moves.dis7.entities.dnk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1d296da
 * Country: Denmark (DNK)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 28831
 */
public class CV9035DK extends EntityType
{
    public CV9035DK()
    {
        setCountry(Country.DENMARK_DNK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 28830, Armored Fighting Vehicle
        setSubCategory((byte)1); // uid 28831, CV9035DK
    }
}
