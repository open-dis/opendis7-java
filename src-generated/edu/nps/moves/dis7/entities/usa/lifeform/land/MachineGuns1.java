package edu.nps.moves.dis7.entities.usa.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@305aaedf
 * Country: United States of America (USA)
 * Entity kind: Life form
 * Domain: LAND
 *
 * Entity type uid: 33045
 */
public class MachineGuns1 extends EntityType
{
    public MachineGuns1()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)12); // uid 32711, U.S. Marine Corps (USMC)
        setSubCategory((byte)35); // uid 33045, Machine Guns
    }
}
