package edu.nps.moves.dis7.entities.pol.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@28486680
 * Country: Poland (POL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23083
 */
public class Project890Class1 extends EntityType
{
    public Project890Class1()
    {
        setCountry(Country.POLAND_POL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)61); // uid 23082, Non-Combatant Ship
        setSubCategory((byte)1); // uid 23083, Project 890 Class
    }
}
