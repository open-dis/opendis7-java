package edu.nps.moves.dis7.entities.dza.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3f8f9dd6
 * Country: Algeria (DZA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27041
 */
public class _901MouradRais1 extends EntityType
{
    public _901MouradRais1()
    {
        setCountry(Country.ALGERIA_DZA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 27039, Frigate (including Corvette)
        setSubCategory((byte)1); // uid 27040, Mourad Rais (Koni) class
        setSpecific((byte)1); // uid 27041, 901 Mourad Rais
    }
}
