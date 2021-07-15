package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6fd1660;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 13500
 */
public class AdmiralKuznetsovexTbilisiexLeonidBrezhnev extends EntityType
{
    /** Default constructor */
    public AdmiralKuznetsovexTbilisiexLeonidBrezhnev()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)1); // uid 13496, Carrier
        setSubCategory((byte)3); // uid 13499, Kuznetsov class (CV)
        setSpecific((byte)1); // uid 13500, Admiral Kuznetsov (ex-Tbilisi, ex-Leonid Brezhnev)
    }
}
