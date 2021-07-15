package edu.nps.moves.dis7.entities.irq.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@2d36e77e;
 * Country: Iraq (IRQ);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 23532
 */
public class D944PSzHIV extends EntityType
{
    /** Default constructor */
    public D944PSzHIV()
    {
        setCountry(Country.IRAQ_IRQ);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 17986, Armored Fighting Vehicle
        setSubCategory((byte)4); // uid 23532, D-944 PSzH-IV
    }
}
