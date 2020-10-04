package edu.nps.moves.dis7.entities.bel.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4f933fd1
 * Country: Belgium (BEL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 23314
 */
public class M915Aster extends EntityType
{
    public M915Aster()
    {
        setCountry(Country.BELGIUM_BEL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 23312, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 23313, Flower class
        setSpecific((byte)1); // uid 23314, M915 Aster
    }
}
