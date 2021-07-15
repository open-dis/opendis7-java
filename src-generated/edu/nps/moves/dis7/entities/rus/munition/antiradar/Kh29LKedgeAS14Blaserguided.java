package edu.nps.moves.dis7.entities.rus.munition.antiradar;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@214b342f;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: ANTI_RADAR;
 *
 * Entity type uid: 20521
 */
public class Kh29LKedgeAS14Blaserguided extends EntityType
{
    /** Default constructor */
    public Kh29LKedgeAS14Blaserguided()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_RADAR));

        setCategory((byte)1); // uid 20509, Guided
        setSubCategory((byte)7); // uid 20519, Kh-29MP Kedge Anti-Radar
        setSpecific((byte)2); // uid 20521, Kh-29L Kedge (AS-14B) laser-guided
    }
}
