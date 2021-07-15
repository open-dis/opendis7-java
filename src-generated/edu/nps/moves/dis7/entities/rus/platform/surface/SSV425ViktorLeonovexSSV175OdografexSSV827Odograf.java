package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4ba380c7;
 * Country: Russia (RUS);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 13903
 */
public class SSV425ViktorLeonovexSSV175OdografexSSV827Odograf extends EntityType
{
    /** Default constructor */
    public SSV425ViktorLeonovexSSV175OdografexSSV827Odograf()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 13805, Auxiliary
        setSubCategory((byte)14); // uid 13901, Vishnya class (AGIs)
        setSpecific((byte)2); // uid 13903, SSV 425 Viktor Leonov (ex-SSV 175 Odograf, ex-SSV 827 Odograf)
    }
}
