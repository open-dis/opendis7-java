package edu.nps.moves.dis7.entities.usa.munition.antipersonnel;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@77b71c9;
 * Country: United States of America (USA);
 * Entity kind: Munition;
 * Domain: ANTI_PERSONNEL;
 *
 * Entity type uid: 19837
 */
public class A556504ballM2M141ratioforM2MGetc extends EntityType
{
    /** Default constructor */
    public A556504ballM2M141ratioforM2MGetc()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_PERSONNEL));

        setCategory((byte)2); // uid 19810, Ballistic
        setSubCategory((byte)5); // uid 19835, 12.7 mm
        setSpecific((byte)2); // uid 19837, A556 .50 4 ball M2/M1 4:1 ratio (for M2 MG, etc.)
    }
}
