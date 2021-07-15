package edu.nps.moves.dis7.entities.oth.supply.class12slingloadsnondoctrinal;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@3caf5c96;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_12_SLING_LOADS_NON_DOCTRINAL;
 *
 * Entity type uid: 30827
 */
public class SlingLoadTorrentulaBucketBBT5566HD660Gal extends EntityType
{
    /** Default constructor */
    public SlingLoadTorrentulaBucketBBT5566HD660Gal()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_12_SLING_LOADS_NON_DOCTRINAL));

        setCategory((byte)4); // uid 30825, Sling Load, Water Bucket
        setSubCategory((byte)2); // uid 30827, Sling Load, Torrentula Bucket (BBT5566HD), 660 Gal
    }
}
