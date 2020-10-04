package edu.nps.moves.dis7.entities.oth.supply.class7majoritems;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@37d3aa8c
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_7_MAJOR_ITEMS
 *
 * Entity type uid: 30770
 */
public class ParaDrogueSargentFletcher extends EntityType
{
    public ParaDrogueSargentFletcher()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_7_MAJOR_ITEMS));

        setCategory((byte)24); // uid 30769, Para-Drogue
        setSubCategory((byte)1); // uid 30770, Para-Drogue Sargent Fletcher
    }
}
