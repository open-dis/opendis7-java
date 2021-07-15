package edu.nps.moves.dis7.entities.col.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2a798d51;
 * Country: Colombia (COL);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27487
 */
public class BL161CartagenadeIndias extends EntityType
{
    /** Default constructor */
    public BL161CartagenadeIndias()
    {
        setCountry(Country.COLOMBIA_COL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27485, Auxiliary
        setSubCategory((byte)1); // uid 27486, Luneburg Class (Type 701, Support Ships)
        setSpecific((byte)1); // uid 27487, BL 161 Cartagena de Indias
    }
}
