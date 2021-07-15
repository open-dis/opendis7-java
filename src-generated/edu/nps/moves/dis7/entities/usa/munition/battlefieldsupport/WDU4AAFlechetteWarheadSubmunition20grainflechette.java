package edu.nps.moves.dis7.entities.usa.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@577f9dfd;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 24974
 */
public class WDU4AAFlechetteWarheadSubmunition20grainflechette extends EntityType
{
    /** Default constructor */
    public WDU4AAFlechetteWarheadSubmunition20grainflechette()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 19971, Ballistic
        setSubCategory((byte)21); // uid 20150, Hydra 70 Rocket System (70 mm, 2.75 in)
        setSpecific((byte)7); // uid 24973, Hydra 70 w/ WDU-4A/A Flechette Warhead
        setExtra((byte)1); // uid 24974, WDU-4A/A Flechette Warhead Submunition (20-grain flechette)
    }
}
