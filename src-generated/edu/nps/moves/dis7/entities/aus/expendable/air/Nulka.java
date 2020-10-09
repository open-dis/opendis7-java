package edu.nps.moves.dis7.entities.aus.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@32f308c6
 * Country: Australia (AUS)
 * Entity kind: Expendable
 * Domain: AIR
 *
 * Entity type uid: 28599
 */
public class Nulka extends EntityType
{
    public Nulka()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 28598, Active emitter
        setSubCategory((byte)1); // uid 28599, Nulka
    }
}
