package edu.nps.moves.dis7.entities.arg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@61e4705b;
 * Country: Argentina (ARG);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 18758
 */
public class CostaSur extends EntityType
{
    /** Default constructor */
    public CostaSur()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 18757, Auxiliary
        setSubCategory((byte)1); // uid 18758, Costa Sur
    }
}
